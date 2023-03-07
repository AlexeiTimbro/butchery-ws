USE `butchery-db`;

create table if not exists customers (

    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(36),
    purchase_id VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    street_address VARCHAR(50),
    city VARCHAR(50),
    province VARCHAR(50),
    country VARCHAR(50),
    postal_code VARCHAR(9)

    );

create table if not exists butchers (

    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    butcher_id VARCHAR(36),
    purchase_id VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    phone_number VARCHAR(50),
    salary DECIMAL(19,4),
    commission_rate DECIMAL(3,1),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9)

    );

create table if not exists meats (

    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    meat_id VARCHAR(50),
    purchase_id VARCHAR(50),
    animal VARCHAR(50),
    environment VARCHAR(50),
    texture VARCHAR(50),
    expiration_date VARCHAR(75),
    price INTEGER(200)

    );

create table if not exists purchases (

    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    purchase_id VARCHAR(50),
    date_time VARCHAR(50),
    total_price VARCHAR(50)

    );