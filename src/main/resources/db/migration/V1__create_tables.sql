CREATE TABLE users
(
    id         BIGSERIAL PRIMARY KEY,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    name       VARCHAR(100) NOT NULL,
    role       VARCHAR(20)  NOT NULL DEFAULT 'ROLE_USER',
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE short_urls
(
    id           BIGSERIAL PRIMARY KEY,
    short_key    VARCHAR(10) NOT NULL UNIQUE,
    original_url TEXT        NOT NULL,
    is_private   BOOLEAN     NOT NULL DEFAULT FALSE,
    expires_at   TIMESTAMP,
    created_by   BIGINT,
    click_count  BIGINT      NOT NULL DEFAULT 0,
    created_at   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_short_urls_users FOREIGN KEY (created_by) REFERENCES users (id)
);

