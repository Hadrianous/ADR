CREATE SEQUENCE IF NOT EXISTS advertiser_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS fetcher_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS product_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE advertiser
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    duration   VARCHAR(255),
    product_id BIGINT,
    CONSTRAINT pk_advertiser PRIMARY KEY (id)
);

CREATE TABLE fetcher
(
    id            BIGINT NOT NULL,
    name          VARCHAR(255),
    type          VARCHAR(255),
    url           VARCHAR(255),
    tag           VARCHAR(255),
    webscraper    VARCHAR(255),
    frequency     INTEGER,
    status        SMALLINT,
    mapping       VARCHAR(255),
    advertiser_id BIGINT,
    CONSTRAINT pk_fetcher PRIMARY KEY (id)
);

CREATE TABLE product
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE advertiser
    ADD CONSTRAINT FK_ADVERTISER_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE fetcher
    ADD CONSTRAINT FK_FETCHER_ON_ADVERTISER FOREIGN KEY (advertiser_id) REFERENCES advertiser (id);