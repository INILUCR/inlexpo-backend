package com.inil.inlexpo.inlexpobackend.repository;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarEstratificacionSocial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarEstratificacionSocialRepository extends JpaRepository<MarEstratificacionSocial, Long> {
  List<MarEstratificacionSocial> findByDiccionario(Diccionario diccionario);
}