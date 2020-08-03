package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiacronica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarDiacronicaRepository extends JpaRepository<MarDiacronica, Long> {
  List<MarDiacronica> findByDiccionario(Diccionario diccionario);
}