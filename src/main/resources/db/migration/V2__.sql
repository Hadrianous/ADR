CREATE SEQUENCE IF NOT EXISTS filter_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE filter
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255),
    field VARCHAR(255),
    value VARCHAR(255),
    CONSTRAINT pk_filter PRIMARY KEY (id)
);

ALTER TABLE fetcher
    ADD date_format VARCHAR(255);

ALTER TABLE fetcher
    ADD CONSTRAINT uc_fetcher_name UNIQUE (name);

ALTER TABLE fetcher
    ALTER COLUMN name SET NOT NULL;

ALTER TABLE fetcher
    ALTER COLUMN status SET NOT NULL;

ALTER TABLE fetcher
    ALTER COLUMN type SET NOT NULL;