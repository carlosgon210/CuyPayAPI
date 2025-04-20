package com.gestoreco.servicio;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.gestoreco.dto.DtoMovimento;

public interface MovimientoService {
	public ResponseEntity<Map<String, Object>> listarMovimiento(int id,int mes, int anio);
	public ResponseEntity<Map<String, Object>> listarPorTipo(int id,String tipo,int mes, int anio);
	public ResponseEntity<Map<String, Object>> calcularBalanceIngresoGasto(int id,int mes,int anio);
	public ResponseEntity<Map<String, Object>> calcularIngresoMensual(int id, int mes, int anio);
	public ResponseEntity<Map<String, Object>> caluclarGastoMensual(int id, int mes, int anio);
	public ResponseEntity<Map<String, Object>> insertarMovimiento(DtoMovimento movimiento);
	
}
