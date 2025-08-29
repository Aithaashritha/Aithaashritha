from sqlalchemy.orm import Session
from app.models.invoice import Invoice, InvoiceLine
from app.schemas.invoice import InvoiceCreate

class InvoiceService:
    def __init__(self, db: Session):
        self.db = db

    def _price_line(self, qty: float, unit_price: int, tax_bps: int):
        net = int(round(qty * unit_price))
        tax = int(round(net * (tax_bps / 10000)))
        return net, tax, net + tax

    def create(self, payload: InvoiceCreate):
        inv = Invoice(
            customer_id=payload.customer_id,
            issue_date=payload.issue_date,
            due_date=payload.due_date,
            currency=payload.currency,
            status="DRAFT"
        )
        total_net = total_tax = total_gross = 0
        for l in payload.lines:
            net, tax, gross = self._price_line(l.quantity, l.unit_price, l.tax_rate_bps)
            inv.lines.append(InvoiceLine(
                description=l.description,
                quantity=l.quantity,
                unit_price=l.unit_price,
                tax_rate_bps=l.tax_rate_bps,
                line_net=net,
                line_tax=tax,
                line_gross=gross
            ))
            total_net += net
            total_tax += tax
            total_gross += gross
        inv.totals_net, inv.totals_tax, inv.totals_gross = total_net, total_tax, total_gross
        self.db.add(inv)
        self.db.commit()
        self.db.refresh(inv)
        return inv

    def get(self, id: str):
        return self.db.query(Invoice).filter(Invoice.id == id).first()

    def list(self, limit=50, offset=0):
        return self.db.query(Invoice).offset(offset).limit(limit).all()
