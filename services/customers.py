from sqlalchemy.orm import Session
from app.models.customer import Customer
from app.schemas.customer import CustomerCreate

class CustomerService:
    def __init__(self, db: Session):
        self.db = db

    def create(self, payload: CustomerCreate):
        cust = Customer(**payload.model_dump())
        self.db.add(cust)
        self.db.commit()
        self.db.refresh(cust)
        return cust

    def list(self, limit=50, offset=0):
        return self.db.query(Customer).offset(offset).limit(limit).all()
