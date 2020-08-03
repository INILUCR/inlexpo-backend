package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfOrtografica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfOrtograficaRepository extends JpaRepository<InfOrtografica, Long> {
  List<InfOrtografica> findByDiccionario(Diccionario diccionario);
}