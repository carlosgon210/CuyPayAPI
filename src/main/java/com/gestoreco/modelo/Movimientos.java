package com.gestoreco.modelo;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="movimientos")
public class Movimientos {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "usuarioId", nullable = false)
	    private int usuarioId;

	    @Column(nullable = false, precision = 10, scale = 2)
	    private BigDecimal monto;

	    @Column(length = 100)
	    private String descripcion;

	    @Column(nullable = false, length = 10)
	    private String tipo; // "ingreso" o "gasto"

	    @Column(nullable = false)
	    private LocalDate fecha;
}
