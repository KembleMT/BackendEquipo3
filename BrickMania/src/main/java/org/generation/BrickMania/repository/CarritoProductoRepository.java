package org.generation.BrickMania.repository;

import org.generation.BrickMania.producto.model.CarritoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, Integer> {
}
