package com.inil.inlexpo.inlexpobackend.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.inil.inlexpo.inlexpobackend.dto.DatosAcepcion;
import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusquedaAvanzadaService {

  @PersistenceContext
  EntityManager entityManager;
  @Autowired
  private ArticuloService articuloSrv;

  public List<Articulo> buscarPorFiltros(Long diccionarioId, DatosAcepcion datosAcepcion) {
    String qlString = "SELECT DISTINCT (ac.articulo.id) FROM Acepcion ac WHERE";

    qlString += " ac.diccionario.id = " + diccionarioId;

    // Primero buscamos la lista de acepciones que cumplan
    if (datosAcepcion.getCatGramaticalId() > 0) {
      qlString += " AND ac.catGramatical.id = " + datosAcepcion.getCatGramaticalId();
    }

    List<Long> articulosId = entityManager.createQuery(qlString).getResultList();
    List<Articulo> articulos = new ArrayList<Articulo>();

    for (int i = 0; i < articulosId.size(); ++i) {
      articulos.add(articuloSrv.buscarPorId(articulosId.get(i)));
    }

    return articulos;
  }
}