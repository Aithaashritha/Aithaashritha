import uuid
from sqlalchemy import Column, String
from app.core.db import Base

class Customer(Base):
    __tablename__ = "customers"
    id = Column(String, primary_key=True, default=lambda: str(uuid.uuid4()))
    name = Column(String, nullable=False)
    email = Column(String, nullable=False)
    tax_id = Column(String, nullable=True)
    country = Column(String, nullable=True)
