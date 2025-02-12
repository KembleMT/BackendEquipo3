-- Usar la base de datos BrickMania
USE BrickMania;

-- Insertando roles
INSERT INTO Roles (nombre_rol) VALUES
('Administrador'), ('Cliente'), ('Vendedor'), ('Soporte'), ('Supervisor'),
('Gestor'), ('Contador'), ('Repartidor'), ('Diseñador'), ('Marketing');

-- Insertando usuarios
INSERT INTO Usuarios (nombre, email, contraseña, direccion, id_rol_fk) VALUES
('Juan Perez', 'juan@example.com', 'hashed_password_1', 'Av. Siempre Viva 123', 2),
('Maria Lopez', 'maria@example.com', 'hashed_password_2', 'Calle Falsa 456', 3),
('Carlos Diaz', 'carlos@example.com', 'hashed_password_3', 'Av. Central 789', 1),
('Ana Gonzalez', 'ana@example.com', 'hashed_password_4', 'Paseo del Bosque 321', 4),
('Luis Torres', 'luis@example.com', 'hashed_password_5', 'Callejón sin Salida 555', 5),
('Sofia Ramirez', 'sofia@example.com', 'hashed_password_6', 'Calle Luna 999', 6),
('Jorge Mendoza', 'jorge@example.com', 'hashed_password_7', 'Av. del Sol 777', 7),
('Fernanda Reyes', 'fernanda@example.com', 'hashed_password_8', 'Carrera 12 #34', 8),
('Diego Soto', 'diego@example.com', 'hashed_password_9', 'Diagonal 45 #23', 9),
('Valeria Cruz', 'valeria@example.com', 'hashed_password_10', 'Zona Industrial 202', 10);

-- Insertando categorías
INSERT INTO Categorias (nombre_categoria) VALUES
('Niños'), ('Adolescentes'), ('Adultos'), ('Principiante'), ('Intermedio'),
('Avanzado'), ('Navidad'), ('Amor y amistad');

-- Insertando productos
INSERT INTO Productos (nombre_producto, descripcion, precio_producto, id_categoria_fk) VALUES
('Lego Set City', 'Set de construcción de ciudad.', 49.99, 1),
('Lego Millennium Falcon', 'Réplica de la nave de Star Wars.', 159.99, 2),
('Lego Camión', 'Camión con funciones mecánicas.', 89.99, 3),
('Lego Casa Friends', 'Casa de muñecas Lego Friends.', 39.99, 4),
('Lego Castillo Hogwarts', 'Castillo de Harry Potter.', 129.99, 5),
('Lego Dragón Ninja', 'Dragón de la serie Ninjago.', 79.99, 6),
('Lego Coche Deportivo', 'Coche con diseño detallado.', 99.99, 7),
('Lego Tren Duplo', 'Tren interactivo para niños.', 59.99, 8),
('Lego Iron Man', 'Figura articulada de Iron Man.', 69.99, 9),
('Lego Batmóvil', 'Batmóvil clásico de Batman.', 89.99, 10);

-- Insertando métodos de pago
INSERT INTO Metodos_Pago (metodo) VALUES
('Tarjeta de Crédito'), ('Tarjeta de Débito'), ('PayPal'), ('Transferencia Bancaria'), ('Efectivo'),
('Criptomonedas'), ('Cheque'), ('Apple Pay'), ('Google Pay'), ('Pago Contra Entrega');

-- Insertando estados de pedido
INSERT INTO Estados_Pedido (estado) VALUES
('Pendiente'), ('Procesando'), ('Enviado'), ('Entregado'), ('Cancelado'),
('Devuelto'), ('En espera'), ('Pago Fallido'), ('Confirmado'), ('Rechazado');

-- Insertando pedidos
INSERT INTO Pedidos (id_usuario_fk, total_pago, fecha_compra, id_metodo_fk, id_estado_fk) VALUES
(1, 199.99, '2024-02-01', 1, 2),
(2, 59.99, '2024-02-02', 3, 1),
(3, 89.99, '2024-02-03', 2, 3),
(4, 129.99, '2024-02-04', 5, 4),
(5, 49.99, '2024-02-05', 4, 5),
(6, 79.99, '2024-02-06', 6, 6),
(7, 39.99, '2024-02-07', 7, 7),
(8, 69.99, '2024-02-08', 8, 8),
(9, 89.99, '2024-02-09', 9, 9),
(10, 159.99, '2024-02-10', 10, 10);

-- Insertando detalles de pedidos
INSERT INTO Detalle_Pedido (id_pedido_fk, id_producto_fk, cantidad, subtotal) VALUES
(1, 2, 1, 159.99),
(2, 4, 1, 39.99),
(3, 3, 1, 89.99),
(4, 5, 1, 129.99),
(5, 1, 1, 49.99),
(6, 6, 1, 79.99),
(7, 7, 1, 99.99),
(8, 8, 1, 59.99),
(9, 9, 1, 69.99),
(10, 10, 1, 89.99);

-- Insertando productos en el carrito
INSERT INTO Carrito_Productos (id_usuario_fk, id_producto_fk, cantidad) VALUES
(1, 3, 2),
(2, 5, 1),
(3, 2, 1),
(4, 7, 3),
(5, 8, 1),
(6, 9, 2),
(7, 10, 1),
(8, 1, 2),
(9, 6, 1),
(10, 4, 3);

SELECT * FROM carrito_productos;
SELECT * FROM categorias;
SELECT * FROM detalle_pedido;
SELECT * FROM estados_pedido;
SELECT * FROM metodos_pago;
SELECT * FROM pedidos;
SELECT * FROM productos;
SELECT * FROM roles;
SELECT * FROM usuarios;
