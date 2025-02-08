package org.generation.BrickMania.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {

    List<MetodoPago> findAll();

    Optional<MetodoPago> findById(Integer id);

    @SuppressWarnings("unchecked")
    MetodoPago save(MetodoPago metodoPago);

    void deleteById(Long id);
}
