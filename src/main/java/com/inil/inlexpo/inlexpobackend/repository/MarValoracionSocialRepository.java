package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarValoracionSocial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarValoracionSocialRepository extends JpaRepository<MarValoracionSocial, Long> {
  List<MarValoracionSocial> findByDiccionario(Diccionario diccionario);
}