package com.gestoreco.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gestoreco.modelo.Usuarios;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer> {

	boolean existsByUsuario(String usuario);
	boolean existsByEmail(String email);
	Usuarios findByUsuario(String usuario);
	
	
}
