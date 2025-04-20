package com.gestoreco.servicio.impl;

import java.time.LocalDate;
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
		if(!dtoRegistrar.getClave1().equals(dtoRegistrar.getClave2())) {
			res.put("mensaje", "Error las claves no son iguales");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		if(userRepo.existsByUsuario(dtoRegistrar.getUsuario())) {
			res.put("mensaje", "Usuario ya esta registrado");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		if(userRepo.existsByEmail(dtoRegistrar.getEmail())) {
			res.put("mensaje", "El correo ya esta siendo usado");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		else {
			Usuarios u= new Usuarios();
			u.setNombre(dtoRegistrar.getNombre()+" "+dtoRegistrar.getApellidos());
			u.setEmail(dtoRegistrar.getEmail());
			u.setUsuario(dtoRegistrar.getUsuario());
			u.setClave(dtoRegistrar.getClave1());
			u.setFechaRegistro(LocalDate.now());
			userRepo.save(u);
			res.put("mensaje", "Usuario Registrado");
			res.put("status",HttpStatus.OK);
			res.put("usuario", u);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}		
	}

	@Override
	public ResponseEntity<Map<String, Object>> inicioSecion(DtoUsuarioSession dtoSesion) {
		Map<String, Object> res= new HashMap<>();
		Usuarios u = userRepo.findByUsuario(dtoSesion.getUsuario());
		System.out.println(dtoSesion.getClave()+"="+u.getClave());
		if(!userRepo.existsByUsuario(dtoSesion.getUsuario())) {
			res.put("mensaje", "No se encontro el Usuario");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		if(!dtoSesion.getClave().equals(u.getClave())) {
			res.put("mensaje", "Contraseña Incorrecta");
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		else {
			res.put("mensaje", "Inicio Sesion");
			res.put("status",HttpStatus.OK);
			res.put("usuario", u);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}	
	}

	

}
