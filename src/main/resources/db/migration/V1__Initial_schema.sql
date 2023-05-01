CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    book_isbn varchar(255) NOT NULL,
    book_name varchar(255) NOT NULL,
    book_price float8 NOT NULL,
    quantity INTEGER NOT NULL,
    status varchar(255) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP NOT NULL,
    version integer NOT NULL
);