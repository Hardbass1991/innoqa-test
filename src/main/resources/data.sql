INSERT INTO brands (name) VALUES ('Coca-Cola');
INSERT INTO brands (name) VALUES ('Apple');
INSERT INTO brands (name) VALUES ('LG');

INSERT INTO products (name) VALUES ('microphone');
INSERT INTO products (name) VALUES ('laptop');
INSERT INTO products (name) VALUES ('energy drink');
INSERT INTO products (name) VALUES ('GAA drink');

INSERT INTO products (PRODUCT_ID, name) Values (35455, 'printer');

INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, '2020-06-14 00:00:00.000-05:00', '2020-12-31 23:59:59.000-05:00', 35455, 0, 35.50, 'EUR');
INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, '2020-06-14 15:00:00.000-05:00', '2020-06-14 18:30:00.000-05:00', 35455, 1, 25.45, 'EUR');
INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, '2020-06-15 00:00:00.000-05:00', '2020-06-15 11:00:00.000-05:00', 35455, 1, 30.50, 'EUR');
INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, '2020-06-15 16:00:00.000-05:00', '2020-12-31 23:59:59.000-05:00', 35455, 1, 38.95, 'EUR');

INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (2, '2020-06-14 00:00:00.000-05:00', '2020-12-31 23:59:59.000-05:00', 35455, 0, 35.50, 'EUR');
INSERT INTO pricelists (BRAND_ID, START_DATE, END_DATE, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES (1, '2020-06-14 00:00:00.000-05:00', '2020-12-31 23:59:59.000-05:00', 2, 0, 35.50, 'EUR');
