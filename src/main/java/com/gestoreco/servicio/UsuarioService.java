package com.gestoreco.servicio;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.gestoreco.dto.DtoUsuarioRegistroo;
import com.gestoreco.dto.DtoUsuarioSession;

public interface UsuarioService {
	
	public ResponseEntity<Map<String, Object>> registrar(DtoUsuarioRegistroo dtoRegistrar);
	public ResponseEntity<Map<String, Object>> inicioSecion(DtoUsuarioSession dtoSesion);

}
