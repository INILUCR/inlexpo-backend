package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarValoracionSocial;
import com.inil.inlexpo.inlexpobackend.repository.MarValoracionSocialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarValoracionSocialService {

  @Autowired
  private MarValoracionSocialRepository marValoracionSocialRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarValoracionSocial buscarPorId(Long marValoracionSocialId) {
    return marValoracionSocialRep.findById(marValoracionSocialId).orElse(null);
  }

  public List<MarValoracionSocial> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marValoracionSocialRep.findByDiccionario(diccionario);
  }

  public MarValoracionSocial crear(Long diccionarioId, MarValoracionSocial marValoracionSocial) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marValoracionSocial.setDiccionario(diccionario);

    return marValoracionSocialRep.save(marValoracionSocial);
  }
}