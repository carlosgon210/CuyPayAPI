package com.gestoreco.servicio.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gestoreco.dto.DtoUsuarioRegistroo;
import com.gestoreco.dto.DtoUsuarioSession;
import com.gestoreco.modelo.Usuarios;
import com.gestoreco.repository.IUsuarioRepository;
import com.gestoreco.servicio.UsuarioService;

@Service 
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private IUsuarioRepository userRepo;

	@Override
	public ResponseEntity<Map<String, Object>> registrar(DtoUsuarioRegistroo dtoRegistrar) {
		
		Map<String, Object> res= new HashMap<>();
		if(dtoRegistrar.getClave1()!=dtoRegistrar.getClave2()) {
			res.put("mensaje", "Error las claves no son iguales");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		else {
			Usuarios u= new Usuarios();
			u.setNombre(dtoRegistrar.getNombre()+dtoRegistrar.getApellidos());
			u.setEmail(dtoRegistrar.getEmail());
			u.setClave(dtoRegistrar.getClave1());
			u.setFechaRegistro(LocalDateTime.now());
		
			res.put("mensaje", "Usuario Registrado");
			res.put("status",HttpStatus.OK);
			res.put("usuario", u);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}		
	}

	@Override
	public ResponseEntity<Map<String, Object>> inicioSecion(DtoUsuarioSession dtoSesion) {
		Map<String, Object> res= new HashMap<>();
		if(!userRepo.existsByEmail(dtoSesion.getUsuario())) {
			res.put("mensaje", "No se encontro el Usuario");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		else {
			Optional<Usuarios> u= userRepo.findByUsuario(dtoSesion.getUsuario());
			res.put("mensaje", "Inicio Sesion");
			res.put("status",HttpStatus.OK);
			res.put("usuario", u);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}	
	}

	

}
