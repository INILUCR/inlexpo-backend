package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.MarPragmatica;
import com.inil.inlexpo.inlexpobackend.repository.MarPragmaticaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarPragmaticaService {

  @Autowired
  private MarPragmaticaRepository marPragmaticaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public MarPragmatica buscarPorId(Long marPragmaticaId) {
    return marPragmaticaRep.findById(marPragmaticaId).orElse(null);
  }

  public List<MarPragmatica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return marPragmaticaRep.findByDiccionario(diccionario);
  }

  public MarPragmatica crear(Long diccionarioId, MarPragmatica marPragmatica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    marPragmatica.setDiccionario(diccionario);

    return marPragmaticaRep.save(marPragmatica);
  }

  public MarPragmatica actualizar(Long marPragmaticaId, MarPragmatica marPragmatica) {
    MarPragmatica marPragmaticaActual = marPragmaticaRep.findById(marPragmaticaId).orElse(null);
    marPragmaticaActual.setNombre(marPragmatica.getNombre());
    marPragmaticaActual.setDescripcion(marPragmatica.getDescripcion());

    final MarPragmatica marPragmaticaActualizada = marPragmaticaRep.save(marPragmaticaActual);
    return marPragmaticaActualizada;
  }

  public Boolean eliminar(Long marPragmaticaId) {
    MarPragmatica marPragmatica = marPragmaticaRep.findById(marPragmaticaId).orElse(null);

    marPragmaticaRep.delete(marPragmatica);
    return true;
  }
}