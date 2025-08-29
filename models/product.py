import uuid
from sqlalchemy import Column, String, Integer, Boolean
from app.core.db import Base

class Product(Base):
    __tablename__ = "products"
    id = Column(String, primary_key=True, default=lambda: str(uuid.uuid4()))
    name = Column(String, nullable=False)
    sku = Column(String, unique=True, nullable=True)
    price = Column(Integer, nullable=False)  # minor units (paise)
    currency = Column(String(3), nullable=False, default="INR")
    tax_rate_bps = Column(Integer, nullable=False, default=0)  # 1800 = 18%
    active = Column(Boolean, default=True)
