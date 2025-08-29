import uuid
from sqlalchemy import Column, String, Date, Integer, ForeignKey, Numeric
from sqlalchemy.orm import relationship
from app.core.db import Base

class Invoice(Base):
    __tablename__ = "invoices"
    id = Column(String, primary_key=True, default=lambda: str(uuid.uuid4()))
    customer_id = Column(String, ForeignKey("customers.id"), nullable=False)
    currency = Column(String(3), nullable=False, default="INR")
    issue_date = Column(Date, nullable=False)
    due_date = Column(Date, nullable=False)
    status = Column(String, nullable=False, default="DRAFT")
    totals_net = Column(Integer, nullable=False, default=0)
    totals_tax = Column(Integer, nullable=False, default=0)
    totals_gross = Column(Integer, nullable=False, default=0)

    lines = relationship("InvoiceLine", back_populates="invoice", cascade="all, delete-orphan")

class InvoiceLine(Base):
    __tablename__ = "invoice_lines"
    id = Column(String, primary_key=True, default=lambda: str(uuid.uuid4()))
    invoice_id = Column(String, ForeignKey("invoices.id", ondelete="CASCADE"), nullable=False)
    description = Column(String, nullable=False)
    quantity = Column(Numeric(18,6), nullable=False)
    unit_price = Column(Integer, nullable=False)        # minor units (paise)
    tax_rate_bps = Column(Integer, nullable=False, default=0)  # basis points
    line_net = Column(Integer, nullable=False, default=0)
    line_tax = Column(Integer, nullable=False, default=0)
    line_gross = Column(Integer, nullable=False, default=0)

    invoice = relationship("Invoice", back_populates="lines")
