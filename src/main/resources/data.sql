CREATE TABLE PRODUCT
(
    id         INT            NOT NULL AUTO_INCREMENT,
    name       VARCHAR(50)    NOT NULL,
    image      INT            NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    created_at DATETIME       NOT NULL default current_timestamp,
    PRIMARY KEY (id)
);


