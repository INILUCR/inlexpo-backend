package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatecnica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarDiatecnicaRepository extends JpaRepository<MarDiatecnica, Long> {
  List<MarDiatecnica> findByDiccionario(Diccionario diccionario);
}