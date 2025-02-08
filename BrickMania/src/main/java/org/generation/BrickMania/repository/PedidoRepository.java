package org.generation.BrickMania.repository;

import java.util.List;
import java.util.Optional;

import org.generation.BrickMania.producto.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findAll();

	Optional<Pedido> findById(Integer id);

	@SuppressWarnings("unchecked")
	Pedido save(Pedido pedido);

	void deleteById(Integer id);
	
	

}
