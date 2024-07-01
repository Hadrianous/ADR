

ALTER TABLE filter
    ADD created_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE filter
    ADD update_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE filter
    ALTER COLUMN created_at SET NOT NULL;

ALTER TABLE product
    ADD created_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE product
    ADD update_at TIMESTAMP WITHOUT TIME ZONE;

ALTER TABLE product
    ALTER COLUMN created_at SET NOT NULL;

ALTER TABLE filter
    ALTER COLUMN update_at SET NOT NULL;

ALTER TABLE product
    ALTER COLUMN update_at SET NOT NULL;

CREATE SEQUENCE IF NOT EXISTS filter_id_seq;
ALTER TABLE filter
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE filter
    ALTER COLUMN id SET DEFAULT nextval('filter_id_seq');

ALTER SEQUENCE filter_id_seq OWNED BY filter.id;

CREATE SEQUENCE IF NOT EXISTS product_id_seq;
ALTER TABLE product
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE product
    ALTER COLUMN id SET DEFAULT nextval('product_id_seq');

ALTER SEQUENCE product_id_seq OWNED BY product.id;