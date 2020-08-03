package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatopica;
import com.inil.inlexpo.inlexpobackend.repository.MarDiatopicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarDiatopicaService {
  
  @Autowired
  private MarDiatopicaRepository marDiatopicaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarDiatopica buscarPorId(Long marDiatopicaId) {
    return marDiatopicaRep.findById(marDiatopicaId).orElse(null);
  }

  public List<MarDiatopica> buscarPorDiccionario(Long diccionarioId) {
		Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
		return marDiatopicaRep.findByDiccionario(diccionario);
	}

  public MarDiatopica crear(Long diccionarioId, MarDiatopica marDiatopica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marDiatopica.setDiccionario(diccionario);

    return marDiatopicaRep.save(marDiatopica);
  }
}