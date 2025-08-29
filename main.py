from fastapi import FastAPI
from mangum import Mangum
from app.core.db import Base, engine
from app.models import customer, product, invoice  # register models
from app.api import health, customers, products, invoices

app = FastAPI(title="Invoice Management System")

# Create tables on startup (SQLite local)
@app.on_event("startup")
def on_startup():
    Base.metadata.create_all(bind=engine)

# Routers
app.include_router(health.router)
app.include_router(customers.router)
app.include_router(products.router)
app.include_router(invoices.router)

# AWS Lambda handler
handler = Mangum(app)
