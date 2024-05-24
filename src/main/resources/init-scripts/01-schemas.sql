CREATE TABLE tb_clients (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE,
    name VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE tb_users (
    username VARCHAR(255) PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE tb_items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    price DECIMAL(19, 4),
    quantity FLOAT,
    description VARCHAR(255),
    images VARCHAR(1000)
);


CREATE TABLE tb_orders (
    id SERIAL PRIMARY KEY,
    requester_id BIGINT,
    requested_at TIMESTAMP,
    updated_at TIMESTAMP,
    amount DECIMAL(19, 4),
    status VARCHAR(255),
    FOREIGN KEY (requester_id) REFERENCES tb_clients(id)
);


CREATE TABLE tb_order_items (
    id SERIAL PRIMARY KEY,
    order_id BIGINT,
    item_id BIGINT,
    quantity FLOAT,
    FOREIGN KEY (order_id) REFERENCES tb_orders(id),
    FOREIGN KEY (item_id) REFERENCES tb_items(id)
);
