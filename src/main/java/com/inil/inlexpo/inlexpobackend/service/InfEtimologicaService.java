package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfEtimologica;
import com.inil.inlexpo.inlexpobackend.repository.InfEtimologicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfEtimologicaService {

  @Autowired
  private InfEtimologicaRepository infEtimologicaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public InfEtimologica buscarPorId(Long infEtimologicaId) {
    return infEtimologicaRep.findById(infEtimologicaId).orElse(null);
  }

  public List<InfEtimologica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return infEtimologicaRep.findByDiccionario(diccionario);
  }

  public InfEtimologica crear(Long diccionarioId, InfEtimologica infEtimologica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    infEtimologica.setDiccionario(diccionario);

    return infEtimologicaRep.save(infEtimologica);
  }
}