CREATE TABLE public.book
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255)  NOT NULL,
    category    VARCHAR(255)  NOT NULL,
    description TEXT          NOT NULL,
    price       NUMERIC(9, 2) NOT NULL,
    currency    CHAR(3)       NOT NULL
);
