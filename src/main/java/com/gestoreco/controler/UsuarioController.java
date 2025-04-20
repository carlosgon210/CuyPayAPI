package com.gestoreco.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestoreco.dto.DtoUsuarioRegistroo;
import com.gestoreco.dto.DtoUsuarioSession;
import com.gestoreco.servicio.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService userService;
	

	@PostMapping("/registrar")
	public ResponseEntity<Map<String, Object>> registrar(@RequestBody DtoUsuarioRegistroo dtoUser){
		return userService.registrar(dtoUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> incioSeccion(@RequestBody DtoUsuarioSession dtoUser){
		return userService.inicioSecion(dtoUser);
	}
}
