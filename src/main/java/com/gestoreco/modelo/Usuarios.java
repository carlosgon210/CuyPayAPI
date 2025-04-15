package com.gestoreco.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="usuarios")
public class Usuarios {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 private String nombre;

	 @Column(unique = true, nullable = false)
	 private String email;

	 @Column(name = "clave", nullable = false)
	 private String clave;

	 @Column(name = "fecha_registro")
	 private LocalDateTime fechaRegistro;
	 
	 
	 @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	 private List<Movimientos> movimientos;

}
