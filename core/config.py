import os

class Settings:
    # SQLite for local development in IDLE; replace with Postgres URL for AWS
    DB_URL = os.getenv("DB_URL", "sqlite:///./ims.db")

settings = Settings()
