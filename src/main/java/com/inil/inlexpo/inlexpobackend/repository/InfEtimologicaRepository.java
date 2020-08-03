package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfEtimologica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfEtimologicaRepository extends JpaRepository<InfEtimologica, Long> {
  List<InfEtimologica> findByDiccionario(Diccionario diccionario);
}