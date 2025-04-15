package com.gestoreco.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestoreco.modelo.Usuarios;

public interface IUsuarioRepository extends JpaRepository<Usuarios, Integer> {

	boolean existsByEmail(String email);
	Optional<Usuarios> findByUsuario(String usuario);
}
