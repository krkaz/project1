CREATE TABLE warehouse_state (
    product_id BIGINT NOT NULL,
    quantity BIGINT DEFAULT 0
);

ALTER TABLE warehouse_state ADD CONSTRAINT UNIQUE(product_id);
