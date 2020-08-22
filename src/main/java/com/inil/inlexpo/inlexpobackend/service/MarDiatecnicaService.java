package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatecnica;
import com.inil.inlexpo.inlexpobackend.repository.MarDiatecnicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarDiatecnicaService {

  @Autowired
  private MarDiatecnicaRepository marDiatecnicaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarDiatecnica buscarPorId(Long marDiatecnicaId) {
    return marDiatecnicaRep.findById(marDiatecnicaId).orElse(null);
  }

  public List<MarDiatecnica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marDiatecnicaRep.findByDiccionario(diccionario);
  }

  public MarDiatecnica crear(Long diccionarioId, MarDiatecnica marDiatecnica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marDiatecnica.setDiccionario(diccionario);

    return marDiatecnicaRep.save(marDiatecnica);
  }

  public MarDiatecnica actualizar(Long marDiatecnicaId, MarDiatecnica marDiatecnica) {
    MarDiatecnica marDiatecnicaActual = marDiatecnicaRep.findById(marDiatecnicaId).orElse(null);
    marDiatecnicaActual.setNombre(marDiatecnica.getNombre());
    marDiatecnicaActual.setDescripcion(marDiatecnica.getDescripcion());

    final MarDiatecnica marDiatecnicaActualizada = marDiatecnicaRep.save(marDiatecnicaActual);
    return marDiatecnicaActualizada;
  }

  public Boolean eliminar(Long marDiatecnicaId) {
    MarDiatecnica marDiatecnica = marDiatecnicaRep.findById(marDiatecnicaId).orElse(null);

    marDiatecnicaRep.delete(marDiatecnica);
    return true;
  }
}