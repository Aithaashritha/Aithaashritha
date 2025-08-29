from pydantic import BaseModel, Field, ConfigDict
from typing import List
from datetime import date

class InvoiceLineIn(BaseModel):
    description: str
    quantity: float = Field(gt=0)
    unit_price: int = Field(ge=0)
    tax_rate_bps: int = 0

class InvoiceCreate(BaseModel):
    customer_id: str
    issue_date: date
    due_date: date
    currency: str = "INR"
    lines: List[InvoiceLineIn]

class InvoiceLineOut(InvoiceLineIn):
    id: str
    line_net: int
    line_tax: int
    line_gross: int
    model_config = ConfigDict(from_attributes=True)

class InvoiceOut(BaseModel):
    id: str
    customer_id: str
    currency: str
    issue_date: date
    due_date: date
    status: str
    totals_net: int
    totals_tax: int
    totals_gross: int
    lines: List[InvoiceLineOut]
    model_config = ConfigDict(from_attributes=True)
