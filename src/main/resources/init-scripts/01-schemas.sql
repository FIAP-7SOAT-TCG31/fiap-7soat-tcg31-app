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

INSERT INTO tb_users (
        email,
        name,
        password,
        role,
        username
) VALUES (
    'admin@admin.com',
    'Administrator',
    '$2a$10$WLrGTAB4pctxD/KMr26quuf/4dtZgvqX241EMy1QOXuAG9a9uu052'
    ,'ADMIN',
    'admin'
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
    payment_id VARCHAR(255),
    FOREIGN KEY (requester_id) REFERENCES tb_clients(id),
    FOREIGN KEY (payment_id) REFERENCES tb_payments(id)
);

CREATE TABLE tb_order_items (
    id SERIAL PRIMARY KEY,
    order_id BIGINT,
    item_id BIGINT,
    quantity FLOAT,
    note VARCHAR(255),
    done BOOLEAN,
    FOREIGN KEY (order_id) REFERENCES tb_orders(id),
    FOREIGN KEY (item_id) REFERENCES tb_items(id)
);

CREATE TABLE tb_payments (
    id VARCHAR(255) PRIMARY KEY,
    was_paid boolean not null,
    paid_at TIMESTAMP,
    method VARCHAR(255)
);

CREATE TABLE tb_payment_details (
    id SERIAL PRIMARY KEY,
    payment_id varchar(255),
    key VARCHAR(255),
    value varchar(255),
    FOREIGN KEY (payment_id) REFERENCES tb_payments(id)
);

