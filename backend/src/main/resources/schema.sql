drop schema if exists app cascade;

create schema app;

CREATE TABLE app.products (
    product_id TEXT PRIMARY KEY NOT NULL UNIQUE,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    status BOOLEAN NOT NULL
);