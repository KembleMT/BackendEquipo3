-- CREAR ESQUEMA O BASE DE DATOS USANDO MYSQL

CREATE DATABASE `ch49_new`;

-- Indicarle a MySQL que voy a usar la DB creada para modificarla
USE `ch49_new`;

-- -------------------------------------------
-- Crear tabla users -------------------------
-- -------------------------------------------
CREATE TABLE `users` (
	-- Agregar columnas: nombre y propiedades
    `id_user` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `username` VARCHAR(30) NOT NULL UNIQUE,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(60) NOT NULL,
    `user_registred` DATE NOT NULL
);

-- -------------------------------------------
-- Crear tabla orders ------------------------
-- -------------------------------------------
CREATE TABLE `orders` (
	`id_order` INT NOT NULL AUTO_INCREMENT,
    `amount` FLOAT NOT NULL,
    `address` VARCHAR(250) NOT NULL,
    `order_date` DATETIME NOT NULL,
    `users_id_user` INT NOT NULL,
    PRIMARY KEY (`id_order`, `users_id_user`),
    INDEX `fk_orders_users_idx` (`users_id_user` ASC),
    -- Relacionando con la Tabla Users (1:N)
    CONSTRAINT `fk_orders_users`
		FOREIGN KEY (`users_id_user`)
        REFERENCES `users` (`id_user`)
);

-- -------------------------------------------
-- Crear tabla products ----------------------
-- -------------------------------------------
CREATE TABLE `products` (
	`id_products` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `product_name` VARCHAR(100) NOT NULL
    -- Intenté agregar otra columna después de crear la tabla pero no me lo permitió
    -- `description` VARCHAR(180) NOT NULL
);

-- Actualizar Tabla products
-- Agregar, modificar, eliminar
ALTER TABLE `products` ADD COLUMN `description` VARCHAR(180) NOT NULL;
ALTER TABLE `products` ADD COLUMN `price` DOUBLE(7, 2) NOT NULL;
ALTER TABLE `products` MODIFY COLUMN `price` FLOAT(7) NOT NULL;
ALTER TABLE `products` DROP COLUMN `price`;

-- Ejecutando Ingeniería Inversa (Reverse Engineer). A partir de un schema podemos generar el MER (modelo Entidad-Relación)
-- En DATABASE, seleccionamos Reverse Engineer y seleccionamos la DB a la cual le queremos aplicar Ing. Inversa

-- --------------------------------------------------------------------------
-- Crear tabla products_has_orders que será una tabla de unión (tabla pivote)
-- --------------------------------------------------------------------------
CREATE TABLE `products_has_orders` (
	`products_id_products` INT NOT NULL,
    `orders_id_order` INT NOT NULL,
    `orders_users_id_user` INT NOT NULL,
    PRIMARY KEY(`products_id_products`, `orders_id_order`, `orders_users_id_user`),
    -- Índices para relacionar las llaves foráneas
    INDEX `fk_products_has_orders_products1_idx` (`products_id_products` ASC),
    INDEX `fk_products_has_orders_orders1_idx` (`orders_id_order` ASC, `orders_users_id_user` ASC),
    -- Relación Muchos a Muchos con `products` y `orders`
    CONSTRAINT `fk_products_has_orders_products1`
		FOREIGN KEY (`products_id_products`)
        REFERENCES `products` (`id_products`),
	CONSTRAINT `fk_products_has_orders_orders1`
		FOREIGN KEY (`orders_id_order`, `orders_users_id_user`)
        REFERENCES `orders` (`id_order`, `users_id_user`)
);

