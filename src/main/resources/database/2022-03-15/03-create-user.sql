CREATE TABLE public.application_user
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255),
    surname  VARCHAR(255),
    email    VARCHAR(255),
    phone    VARCHAR(255),
    password VARCHAR(255),
    type     VARCHAR(255)
);