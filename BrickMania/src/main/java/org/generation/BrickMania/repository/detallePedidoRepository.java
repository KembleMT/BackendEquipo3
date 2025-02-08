package org.generation.BrickMania.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface detallePedidoRepository extends JpaRepository<DetallePedido, Integer> {

    List<DetallePedido> findAll();

    Optional<DetallePedido> findById(Long id);

    @SuppressWarnings("unchecked")
    DetallePedido save(DetallePedido detallePedido);

    void deleteById(Long id);
}
