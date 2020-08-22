package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarEstratificacionSocial;
import com.inil.inlexpo.inlexpobackend.repository.MarEstratificacionSocialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarEstratificacionSocialService {

  @Autowired
  private MarEstratificacionSocialRepository marEstratificacionSocialRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarEstratificacionSocial buscarPorId(Long marEstratificacionSocialId) {
    return marEstratificacionSocialRep.findById(marEstratificacionSocialId).orElse(null);
  }

  public List<MarEstratificacionSocial> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marEstratificacionSocialRep.findByDiccionario(diccionario);
  }

  public MarEstratificacionSocial crear(Long diccionarioId, MarEstratificacionSocial marEstratificacionSocial) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marEstratificacionSocial.setDiccionario(diccionario);

    return marEstratificacionSocialRep.save(marEstratificacionSocial);
  }

  public MarEstratificacionSocial actualizar(Long marEstratificacionSocialId,
      MarEstratificacionSocial marEstratificacionSocial) {
    MarEstratificacionSocial marEstratificacionSocialActual = marEstratificacionSocialRep
        .findById(marEstratificacionSocialId).orElse(null);
    marEstratificacionSocialActual.setNombre(marEstratificacionSocial.getNombre());
    marEstratificacionSocialActual.setDescripcion(marEstratificacionSocial.getDescripcion());

    final MarEstratificacionSocial marEstratificacionSocialActualizada = marEstratificacionSocialRep
        .save(marEstratificacionSocialActual);
    return marEstratificacionSocialActualizada;
  }

  public Boolean eliminar(Long marEstratificacionSocialId) {
    MarEstratificacionSocial marEstratificacionSocial = marEstratificacionSocialRep.findById(marEstratificacionSocialId)
        .orElse(null);

    marEstratificacionSocialRep.delete(marEstratificacionSocial);
    return true;
  }
}