package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcepcionRepository extends JpaRepository<Acepcion, Long> {
  List<Acepcion> findByArticuloOrderByPrioridad(Articulo articulo);
}