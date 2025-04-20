package com.gestoreco.servicio.impl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestoreco.dto.DtoMovimento;
import com.gestoreco.modelo.Movimientos;
import com.gestoreco.repository.IMovimientoRepository;
import com.gestoreco.servicio.MovimientoService;


@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	private IMovimientoRepository movRepo;
	
	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<Map<String, Object>> listarMovimiento(int id, int mes, int anio) {
		Map<String, Object> res =new HashMap<>();
		try {
			List<Movimientos> lstMovimiento = movRepo.listar_Movimiento_mensuales(id, mes, anio);
			res.put("status",HttpStatus.OK);
			res.put("ListaMovimiento", lstMovimiento);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			res.put("mensaje", e.getLocalizedMessage());
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<Map<String, Object>> listarPorTipo(int id, String tipo, int mes, int anio) {
		Map<String, Object> res =new HashMap<>();
		try {
			List<Movimientos> lstMovimientoTipo= movRepo.listar_Movimiento_tipo_mensuales(id,tipo, mes, anio);
			res.put("status",HttpStatus.OK);
			res.put("ListaMovimientoTipo", lstMovimientoTipo);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		} catch (Exception e) {
			res.put("mensaje", e.getLocalizedMessage());
			res.put("status",HttpStatus.CONFLICT);
			return ResponseEntity.status(HttpStatus.OK).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> calcularBalanceIngresoGasto(int id, int mes, int anio) {
		Map<String, Object> res= new HashMap<>();
		try {
			
			Double balance=movRepo.calcular_balance_mensual(id, mes, anio);
		
			res.put("mensaje","calcular Balance Ingreso Gasto");
			res.put("status",HttpStatus.OK);
			res.put("BalanceMensual", balance);
			return ResponseEntity.status(HttpStatus.OK).body(res);
			
		}catch (Exception e) {
		    res.put("mensaje", e.getLocalizedMessage());
		    res.put("status", HttpStatus.CONFLICT);
		    return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> calcularIngresoMensual(int id, int mes, int anio) {
		Map<String, Object> res= new HashMap<>();
		try {
			Double ingreso=movRepo.calcular_Ingreso_mensual(id, mes, anio);
		
			res.put("mensaje","caluclar ingreso Mensual");
			res.put("status",HttpStatus.OK);
			res.put("IngresoMensual", ingreso);
			return ResponseEntity.status(HttpStatus.OK).body(res);
			
		} catch (Exception e) {
			res.put("mensaje", e.getLocalizedMessage());
			res.put("status",HttpStatus.CONFLICT);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}
	}

	@Override
	@Transactional(readOnly = false)
	public ResponseEntity<Map<String, Object>> caluclarGastoMensual(int id, int mes, int anio) {
		Map<String, Object> res= new HashMap<>();
		try {
			Double gasto=movRepo.calcularGastoMensual(id, mes, anio);
		
			res.put("mensaje","caluclar Gasto Mensual");
			res.put("status",HttpStatus.OK);
			res.put("GastoMensual", gasto);
			return ResponseEntity.status(HttpStatus.OK).body(res);
			
		} catch (Exception e) {
			res.put("mensaje", e.getLocalizedMessage());
			res.put("status",HttpStatus.CONFLICT);

			return ResponseEntity.status(HttpStatus.OK).body(res);
		}
	}

	@Override
	public ResponseEntity<Map<String, Object>> insertarMovimiento(DtoMovimento movimiento) {
		Map<String, Object> res= new HashMap<>();
		try {
			Movimientos m =new Movimientos();
			m.setUsuario(movimiento.getUsuarioId());
			m.setMonto(movimiento.getMonto());
			m.setDescripcion(movimiento.getDescripcion());
			m.setTipo(movimiento.getTipo());
			m.setFecha(LocalDate.now());
			movRepo.save(m);
			
			res.put("mensaje","Movimiento añadido");
			res.put("status",HttpStatus.OK);
			res.put("Movimiento", m);
			return ResponseEntity.status(HttpStatus.OK).body(res);
			
		} catch (Exception e) {
			res.put("mensaje", e.getLocalizedMessage());
			res.put("status",HttpStatus.CONFLICT);

			return ResponseEntity.status(HttpStatus.CONFLICT).body(res);
		}
		
		
	}

	
}
