from pydantic import BaseModel, ConfigDict

class ProductCreate(BaseModel):
    name: str
    sku: str | None = None
    price: int
    currency: str = "INR"
    tax_rate_bps: int = 0
    active: bool = True

class ProductOut(ProductCreate):
    id: str
    model_config = ConfigDict(from_attributes=True)
