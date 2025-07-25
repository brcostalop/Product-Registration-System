--CREATE DATABASE productsdb;
INSERT INTO product (id, name, category, price, description)
VALUES (RANDOM_UUID(), 'Camisa 1', 'Camisas', 140.00, 'Camisa nova');