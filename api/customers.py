from typing import List
from fastapi import APIRouter, Depends, HTTPException
from sqlalchemy.orm import Session
from app.core.db import get_db
from app.schemas.customer import CustomerCreate, CustomerOut
from app.services.customers import CustomerService

router = APIRouter(prefix="/api/v1/customers", tags=["customers"])

# Create
@router.post("", response_model=CustomerOut)
def create_customer(payload: CustomerCreate, db: Session = Depends(get_db)):
    return CustomerService(db).create(payload)

# List all
@router.get("", response_model=List[CustomerOut])
def list_customers(db: Session = Depends(get_db)):
    return CustomerService(db).list()

# Get by ID
@router.get("/{customer_id}", response_model=CustomerOut)
def get_customer(customer_id: str, db: Session = Depends(get_db)):
    customer = CustomerService(db).get(customer_id)
    if not customer:
        raise HTTPException(status_code=404, detail="Not Found")
    return customer

# Update
@router.put("/{customer_id}", response_model=CustomerOut)
def update_customer(customer_id: str, payload: CustomerCreate, db: Session = Depends(get_db)):
    updated = CustomerService(db).update(customer_id, payload)
    if not updated:
        raise HTTPException(status_code=404, detail="Not Found")
    return updated

# Delete
@router.delete("/{customer_id}")
def delete_customer(customer_id: str, db: Session = Depends(get_db)):
    deleted = CustomerService(db).delete(customer_id)
    if not deleted:
        raise HTTPException(status_code=404, detail="Not Found")
    return {"message": "Customer deleted successfully"}
