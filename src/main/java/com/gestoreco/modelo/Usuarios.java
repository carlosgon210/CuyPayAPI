package com.gestoreco.modelo;

import java.time.LocalDate;
import java.util.List;

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
	 
	 @Column(unique = true, nullable = false)
	 private String usuario;

	 @Column(name = "clave", nullable = false)
	 private String clave;

	 @Column(name = "fecha_registro")
	 private LocalDate fechaRegistro;
	 
	 
	 @OneToMany(mappedBy = "usuario")
	 private List<Movimientos> movimientos;

}
