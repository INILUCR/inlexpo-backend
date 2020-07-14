package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatGramaticalRepository extends JpaRepository<CatGramatical, Long> {
  List<CatGramatical> findByDiccionario(Diccionario diccionario);
}
