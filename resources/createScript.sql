use mydb;

CREATE TABLE IF NOT EXISTS orders (
  order_id INT NOT NULL AUTO_INCREMENT,
    order_name VARCHAR(45) NOT NULL,
    order_cost int NOT NULL,
    PRIMARY KEY(order_id)
);

CREATE TABLE IF NOT EXISTS couriers (
  courier_id INT NOT NULL AUTO_INCREMENT,
    courier_name VARCHAR(64) NOT NULL,
    courier_salary int NOT NULL,
    PRIMARY KEY(courier_id)
);

CREATE TABLE IF NOT EXISTS delivery (
  delivery_id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    courier_id INT NULL,
    delivery_time int NOT NULL,
    PRIMARY KEY(delivery_id),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (courier_id) REFERENCES couriers(courier_id)
);