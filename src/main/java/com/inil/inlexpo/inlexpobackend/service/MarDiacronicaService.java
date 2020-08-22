package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarDiacronica;
import com.inil.inlexpo.inlexpobackend.repository.MarDiacronicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarDiacronicaService {

  @Autowired
  private MarDiacronicaRepository marDiacronicaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarDiacronica buscarPorId(Long marDiacronicaId) {
    return marDiacronicaRep.findById(marDiacronicaId).orElse(null);
  }

  public List<MarDiacronica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marDiacronicaRep.findByDiccionario(diccionario);
  }

  public MarDiacronica crear(Long diccionarioId, MarDiacronica marDiacronica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marDiacronica.setDiccionario(diccionario);

    return marDiacronicaRep.save(marDiacronica);
  }

  public MarDiacronica actualizar(Long marDiacronicaId, MarDiacronica marDiacronica) {
    MarDiacronica marDiacronicaActual = marDiacronicaRep.findById(marDiacronicaId).orElse(null);
    marDiacronicaActual.setNombre(marDiacronica.getNombre());
    marDiacronicaActual.setDescripcion(marDiacronica.getDescripcion());

    final MarDiacronica marDiacronicaActualizada = marDiacronicaRep.save(marDiacronicaActual);
    return marDiacronicaActualizada;
  }

  public Boolean eliminar(Long marDiacronicaId) {
    MarDiacronica marDiacronica = marDiacronicaRep.findById(marDiacronicaId).orElse(null);

    marDiacronicaRep.delete(marDiacronica);
    return true;
  }
}