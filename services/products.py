from sqlalchemy.orm import Session
from app.models.product import Product
from app.schemas.product import ProductCreate

class ProductService:
    def __init__(self, db: Session):
        self.db = db

    def create(self, payload: ProductCreate):
        prod = Product(**payload.model_dump())
        self.db.add(prod)
        self.db.commit()
        self.db.refresh(prod)
        return prod

    def list(self, limit=50, offset=0):
        return self.db.query(Product).offset(offset).limit(limit).all()
