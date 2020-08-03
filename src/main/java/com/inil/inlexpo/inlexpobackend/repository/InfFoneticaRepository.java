package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfFonetica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfFoneticaRepository extends JpaRepository<InfFonetica, Long> {
  List<InfFonetica> findByDiccionario(Diccionario diccionario);
}