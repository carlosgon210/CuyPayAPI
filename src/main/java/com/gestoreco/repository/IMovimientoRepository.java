package com.gestoreco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.gestoreco.modelo.Movimientos;

public interface IMovimientoRepository  extends JpaRepository<Movimientos, Integer>{

	@Query(value = "CALL calcular_Gasto_mensual(:p_usuarioId, :p_mes, :p_anio)", nativeQuery = true)
    Double calcularGastoMensual(
        @Param("p_usuarioId") int id,
        @Param("p_mes") int mes,
        @Param("p_anio") int anio
    );
	
	@Query(value = "CALL calcular_Ingreso_mensual(:p_usuarioId, :p_mes, :p_anio)", nativeQuery = true)
    Double calcular_Ingreso_mensual(
        @Param("p_usuarioId") int id,
        @Param("p_mes") int mes,
        @Param("p_anio") int anio
    );
	
	@Query(value = "CALL calcular_balance_mensual(:p_usuarioId, :p_mes, :p_anio)", nativeQuery = true)
    Double calcular_balance_mensual(
        @Param("p_usuarioId") int id,
        @Param("p_mes") int mes,
        @Param("p_anio") int anio
    );
	
	@Procedure(procedureName = "listar_Movimiento_tipo_mensuales")
    List<Movimientos> listar_Movimiento_tipo_mensuales(
        @Param("p_usuarioId") int id,
        @Param("p_tipo") String tipo,
        @Param("p_mes") int mes,
        @Param("p_anio") int anio
    );
	
	@Procedure(procedureName = "listar_Movimiento_mensuales")
    List<Movimientos> listar_Movimiento_mensuales(
        @Param("p_usuarioId") int id,
        @Param("p_mes") int mes,
        @Param("p_anio") int anio
    );
	
}
