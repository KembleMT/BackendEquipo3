-- Creando la base de datos de BrickMania.
CREATE DATABASE IF NOT EXISTS BrickMania;
USE BrickMania;

-- ===============================
-- TABLA DE ROLES DE USUARIOS
-- ===============================
CREATE TABLE `Roles` (
    `id_rol` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre_rol` VARCHAR(50) NOT NULL UNIQUE
);

-- ===============================
-- TABLA DE USUARIOS
-- ===============================
CREATE TABLE `Usuarios` (
    `id_usuario` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL,
    `email` VARCHAR(80) NOT NULL UNIQUE,
    `contraseña` VARCHAR(255) NOT NULL, -- Se almacena encriptada
    `direccion` VARCHAR(200),
    `id_rol_fk` INT UNSIGNED NOT NULL,
    FOREIGN KEY (`id_rol_fk`) REFERENCES `Roles`(`id_rol`)
);

-- ==========================================
-- TABLA DE CATEGORÍAS
-- ==========================================
CREATE TABLE `Categorias` (
    `id_categoria` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre_categoria` VARCHAR(50) NOT NULL UNIQUE
);

-- ============================================
-- TABLA DE PRODUCTOS
-- ============================================
CREATE TABLE `Productos` (
    `id_producto` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `nombre_producto` VARCHAR(70) NOT NULL,
    `descripcion` VARCHAR(500),
    `precio_producto` DECIMAL(10,2) NOT NULL CHECK (precio_producto >= 0),
    `id_categoria_fk` INT UNSIGNED NOT NULL,
    FOREIGN KEY (`id_categoria_fk`) REFERENCES `Categorias`(`id_categoria`) ON DELETE CASCADE
);

-- ============================================
-- TABLA DE MÉTODOS DE PAGO
-- ============================================
CREATE TABLE `Metodos_Pago` (
    `id_metodo` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `metodo` VARCHAR(50) NOT NULL UNIQUE
);

-- =============================================
-- TABLA DE ESTADOS DE PEDIDO
-- =============================================
CREATE TABLE `Estados_Pedido` (
    `id_estado` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `estado` VARCHAR(50) NOT NULL UNIQUE
);

-- ===============================================
-- TABLA DE PEDIDOS
-- ===============================================
CREATE TABLE `Pedidos` (
    `id_pedido` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `id_usuario_fk` INT UNSIGNED NOT NULL,
    `total_pago` DECIMAL(10,2) NOT NULL CHECK (total_pago >= 0),
    `fecha_compra` DATE NOT NULL DEFAULT (CURRENT_DATE),
    `id_metodo_fk` INT UNSIGNED NOT NULL,
    `id_estado_fk` INT UNSIGNED NOT NULL,
    FOREIGN KEY (`id_usuario_fk`) REFERENCES `Usuarios`(`id_usuario`) ON DELETE CASCADE,
    FOREIGN KEY (`id_metodo_fk`) REFERENCES `Metodos_Pago`(`id_metodo`),
    FOREIGN KEY (`id_estado_fk`) REFERENCES `Estados_Pedido`(`id_estado`)
);

-- Índice para mejorar consultas por fecha
CREATE INDEX idx_fecha_compra ON `Pedidos`(`fecha_compra`);

-- ===============================================
-- TABLA INTERMEDIA: DETALLE DE PEDIDOS
-- ===============================================
CREATE TABLE `Detalle_Pedido` (
    `id_detalle` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `id_pedido_fk` INT UNSIGNED NOT NULL,
    `id_producto_fk` INT UNSIGNED NOT NULL,
    `cantidad` INT UNSIGNED NOT NULL CHECK (cantidad > 0),
    `subtotal` DECIMAL(10,2) NOT NULL CHECK (subtotal >= 0),
    FOREIGN KEY (`id_pedido_fk`) REFERENCES `Pedidos`(`id_pedido`) ON DELETE CASCADE,
    FOREIGN KEY (`id_producto_fk`) REFERENCES `Productos`(`id_producto`) ON DELETE CASCADE
);

-- =============================================
-- TABLA INTERMEDIA: CARRITO DE COMPRAS
-- =============================================
CREATE TABLE `Carrito_Productos` (
    `id_carrito_producto` INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `id_usuario_fk` INT UNSIGNED NOT NULL,
    `id_producto_fk` INT UNSIGNED NOT NULL,
    `cantidad` INT UNSIGNED NOT NULL CHECK (cantidad > 0),
    FOREIGN KEY (`id_usuario_fk`) REFERENCES `Usuarios`(`id_usuario`) ON DELETE CASCADE,
    FOREIGN KEY (`id_producto_fk`) REFERENCES `Productos`(`id_producto`) ON DELETE CASCADE
);
