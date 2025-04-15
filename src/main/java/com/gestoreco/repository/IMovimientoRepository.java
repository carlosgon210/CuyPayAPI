package com.gestoreco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestoreco.modelo.Movimientos;

public interface IMovimientoRepository  extends JpaRepository<Movimientos, Integer>{

}
