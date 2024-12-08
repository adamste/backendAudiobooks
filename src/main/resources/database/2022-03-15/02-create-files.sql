CREATE TABLE public.file
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255),
    created           TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    summary           TEXT,
    content_id        VARCHAR(255),
    content_length    BIGINT,
    content_mime_type VARCHAR(255)
);
