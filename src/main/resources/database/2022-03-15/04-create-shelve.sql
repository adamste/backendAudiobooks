CREATE TABLE public.shelve
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGSERIAL,
    type       VARCHAR(255),
    book_id BIGSERIAL
);
