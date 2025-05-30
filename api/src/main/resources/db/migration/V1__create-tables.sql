CREATE TABLE users (
    id       SERIAL PRIMARY KEY,
    username VARCHAR(30) NOT NULL UNIQUE,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(24) NOT NULL
);

CREATE TABLE wishlists (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL,
    user_id  INTEGER NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE products (
    id       SERIAL PRIMARY KEY,
    name     VARCHAR(128) NOT NULL,
    link     TEXT,
    price    DECIMAL(10,2) CHECK (price >= 0),
    wishlist_id INTEGER NOT NULL,
    CONSTRAINT fk_wishlist FOREIGN KEY (wishlist_id) REFERENCES wishlists(id)
);