from pydantic import BaseModel, EmailStr, ConfigDict

class CustomerCreate(BaseModel):
    name: str
    email: EmailStr
    tax_id: str | None = None
    country: str | None = None

class CustomerOut(CustomerCreate):
    id: str
    model_config = ConfigDict(from_attributes=True)
