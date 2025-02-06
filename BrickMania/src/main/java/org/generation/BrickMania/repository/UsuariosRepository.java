package org.generation.BrickMania;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository <Usuarios, Long>{
	Optional<Usuarios> findByNombre(String nombre);

}
