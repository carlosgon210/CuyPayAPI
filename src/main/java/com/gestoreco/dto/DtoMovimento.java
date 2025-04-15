package com.gestoreco.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DtoMovimento {
	private int usuarioId;
	private BigDecimal monto;
	private String descripcion;
	private String tipo;
}
