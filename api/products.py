from typing import List
from fastapi import APIRouter, Depends
from sqlalchemy.orm import Session
from app.core.db import get_db
from app.schemas.product import ProductCreate, ProductOut
from app.services.products import ProductService

router = APIRouter(prefix="/api/v1/products", tags=["products"])

@router.post("", response_model=ProductOut)
def create_product(payload: ProductCreate, db: Session = Depends(get_db)):
    return ProductService(db).create(payload)

@router.get("", response_model=List[ProductOut])
def list_products(db: Session = Depends(get_db)):
    return ProductService(db).list()
