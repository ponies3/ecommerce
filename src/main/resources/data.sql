 DROP TABLE IF EXISTS rates;

CREATE TABLE IF NOT EXISTS rates (
    BRAND_ID INT,
    START_DATE TIMESTAMP,
    END_DATE TIMESTAMP,
    ID INT auto_increment primary key,
    PRODUCT_ID INT,
    PRIORITY INT,
    PRICE DECIMAL(5,2),
    CURRENCY VARCHAR(3),
    LAST_UPDATE TIMESTAMP,
    LAST_UPDATE_BY VARCHAR(255)
);

INSERT INTO rates (BRAND_ID, START_DATE, END_DATE, ID, PRODUCT_ID, PRIORITY, PRICE, CURRENCY, LAST_UPDATE, LAST_UPDATE_BY) SELECT BRAND_ID, START_DATE, END_DATE, ID, PRODUCT_ID, PRIORITY, PRICE, CURRENCY, LAST_UPDATE, LAST_UPDATE_BY FROM CSVREAD('classpath:rates.csv');


SELECT * FROM rates;