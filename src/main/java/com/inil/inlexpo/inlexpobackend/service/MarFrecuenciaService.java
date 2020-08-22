package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarFrecuencia;
import com.inil.inlexpo.inlexpobackend.repository.MarFrecuenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarFrecuenciaService {

  @Autowired
  private MarFrecuenciaRepository marFrecuenciaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarFrecuencia buscarPorId(Long marFrecuenciaId) {
    return marFrecuenciaRep.findById(marFrecuenciaId).orElse(null);
  }

  public List<MarFrecuencia> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marFrecuenciaRep.findByDiccionario(diccionario);
  }

  public MarFrecuencia crear(Long diccionarioId, MarFrecuencia marFrecuencia) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marFrecuencia.setDiccionario(diccionario);

    return marFrecuenciaRep.save(marFrecuencia);
  }

  public MarFrecuencia actualizar(Long marFrecuenciaId, MarFrecuencia marFrecuencia) {
    MarFrecuencia marFrecuenciaActual = marFrecuenciaRep.findById(marFrecuenciaId).orElse(null);
    marFrecuenciaActual.setNombre(marFrecuencia.getNombre());
    marFrecuenciaActual.setDescripcion(marFrecuencia.getDescripcion());

    final MarFrecuencia marFrecuenciaActualizada = marFrecuenciaRep.save(marFrecuenciaActual);
    return marFrecuenciaActualizada;
  }

  public Boolean eliminar(Long marFrecuenciaId) {
    MarFrecuencia marFrecuencia = marFrecuenciaRep.findById(marFrecuenciaId).orElse(null);

    marFrecuenciaRep.delete(marFrecuencia);
    return true;
  }
}