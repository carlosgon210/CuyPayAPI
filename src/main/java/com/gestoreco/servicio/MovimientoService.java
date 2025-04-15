package com.gestoreco.servicio;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.gestoreco.dto.DtoMovimento;
import com.gestoreco.modelo.Movimientos;

public interface MovimientoService {
	public ResponseEntity<Map<String, Object>> listarMovimiento(String id,int mes, int anio, int dia);
	public ResponseEntity<Map<String, Object>> calcularMovimiento(String id,int mes,int anio);
	public ResponseEntity<Map<String, Object>> insertarMovimiento(DtoMovimento movimiento);
}
