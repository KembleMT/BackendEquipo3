package org.generation.BrickMania.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findAll();

	Optional<Pedido> findById(Long id);

	@SuppressWarnings("unchecked")
	Pedido save(Pedido pedido);

	void deleteById(Long id);
	
	

}
