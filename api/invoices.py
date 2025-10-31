from typing import List
from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from app.core.db import get_db
from app.schemas.invoice import InvoiceCreate, InvoiceOut
from app.services.invoicing import InvoiceService

router = APIRouter(prefix="/api/v1/invoices", tags=["invoices"])

@router.post("", response_model=InvoiceOut)
def create_invoice(payload: InvoiceCreate, db: Session = Depends(get_db)):
    return InvoiceService(db).create(payload)

@router.get("/{invoice_id}", response_model=InvoiceOut)
def get_invoice(invoice_id: str, db: Session = Depends(get_db)):
    inv = InvoiceService(db).get(invoice_id)
    if not inv:
        raise HTTPException(status_code=404, detail="Invoice not found")
    return inv

@router.get("", response_model=List[InvoiceOut])
def list_invoices(db: Session = Depends(get_db)):
    return InvoiceService(db).list()
