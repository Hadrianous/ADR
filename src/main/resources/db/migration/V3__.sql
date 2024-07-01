ALTER TABLE fetcher
    DROP CONSTRAINT fk_fetcher_on_advertiser;

ALTER TABLE fetcher
    DROP COLUMN advertiser_id;

ALTER TABLE fetcher
    DROP COLUMN mapping;

ALTER TABLE fetcher
    DROP COLUMN webscraper;

ALTER TABLE advertiser
    DROP COLUMN duration;

DROP SEQUENCE fetcher_seq CASCADE;

CREATE SEQUENCE IF NOT EXISTS fetcher_id_seq;
ALTER TABLE fetcher
    ALTER COLUMN id SET NOT NULL;
ALTER TABLE fetcher
    ALTER COLUMN id SET DEFAULT nextval('fetcher_id_seq');

ALTER SEQUENCE fetcher_id_seq OWNED BY fetcher.id;