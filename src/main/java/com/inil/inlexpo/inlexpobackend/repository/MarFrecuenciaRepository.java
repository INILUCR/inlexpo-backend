package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarFrecuencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarFrecuenciaRepository extends JpaRepository<MarFrecuencia, Long> {
  List<MarFrecuencia> findByDiccionario(Diccionario diccionario);
}