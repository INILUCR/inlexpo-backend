package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarPragmatica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarPragmaticaRepository extends JpaRepository<MarPragmatica, Long> {
  List<MarPragmatica> findByDiccionario(Diccionario diccionario);
}