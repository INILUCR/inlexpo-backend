package com.inil.inlexpo.inlexpobackend.repository;

import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
  List<Articulo> findByDiccionarioOrderByLemaAsc(Diccionario diccionario);
}