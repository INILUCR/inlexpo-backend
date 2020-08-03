package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatopica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarDiatopicaRepository extends JpaRepository<MarDiatopica, Long> {
  List<MarDiatopica> findByDiccionario(Diccionario diccionario);
}