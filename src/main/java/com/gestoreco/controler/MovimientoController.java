package com.gestoreco.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestoreco.dto.DtoMovimento;
import com.gestoreco.servicio.MovimientoService;

@RestController
@RequestMapping("/api/movimiento")
public class MovimientoController {

	@Autowired
	private MovimientoService movService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<Map<String, Object>> listarMovimiento(@RequestParam int id,
            													@RequestParam int mes,
            													@RequestParam int anio){
		return movService.listarMovimiento(id,mes,anio);
	}
	
	@GetMapping("/listarPorTipo")
	public ResponseEntity<Map<String, Object>> listarPorTipo( 	@RequestParam int id,
																@RequestParam String tipo,
																@RequestParam int mes,
																@RequestParam int anio){
		return movService.listarPorTipo(id, tipo, mes, anio);
	}
	
	@GetMapping("/balance")
	public ResponseEntity<Map<String, Object>> calcularBalanceIngresoGasto(	@RequestParam int id,
																			@RequestParam int mes,
																			@RequestParam int anio){
		return movService.calcularBalanceIngresoGasto(id, mes, anio);
	}
	
	@GetMapping("/ingreso")
	public ResponseEntity<Map<String, Object>> calcularIngresoMensual(	@RequestParam int id,
																		@RequestParam int mes,
																		@RequestParam int anio){
		return movService.calcularIngresoMensual(id, mes, anio);
	}
	
	@GetMapping("/gasto")
	public ResponseEntity<Map<String, Object>> caluclarGastoMensual(@RequestParam int id,
																	@RequestParam int mes,
																	@RequestParam int anio){
		return movService.caluclarGastoMensual(id, mes, anio);
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<Map<String, Object>> insertarMovimiento(@RequestBody DtoMovimento movimiento){
		return movService.insertarMovimiento(movimiento);
	}
	
	
}
