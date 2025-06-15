CREATE DATABASE proveedores;
USE proveedores;

CREATE TABLE proveedor (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  contacto VARCHAR(100) NOT NULL,
  tipo_producto VARCHAR(50) NOT NULL
);

-- Datos de prueba
INSERT INTO proveedor (nombre, contacto, tipo_producto) VALUES
('L’Oréal', 'contacto@loreal.com', 'Cosméticos'),
('Fragancias XYZ', 'ventas@fragxyz.com', 'Perfumería');
