package org.generation.BrickMania.repository;

import java.util.Optional;
import org.generation.BrickMania.producto.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository <Usuarios, Long>{
	Optional<Usuarios> findByEmail(String email);

}
