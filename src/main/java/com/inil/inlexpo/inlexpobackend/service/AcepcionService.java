package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.repository.AcepcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcepcionService {

  @Autowired
  private AcepcionRepository acepcionRep;
  @Autowired
  private ArticuloService articuloSrv;

  public List<Acepcion> buscarPorArticulo(Long articuloId) {
    Articulo articulo = articuloSrv.buscarPorId(articuloId);
    return acepcionRep.findByArticuloOrderByPrioridad(articulo);
  }
}