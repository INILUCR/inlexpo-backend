package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfMorfologica;
import com.inil.inlexpo.inlexpobackend.repository.InfMorfologicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfMorfologicaService {

  @Autowired
  private InfMorfologicaRepository infMorfologicaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public InfMorfologica buscarPorId(Long infMorfologicaId) {
    return infMorfologicaRep.findById(infMorfologicaId).orElse(null);
  }

  public List<InfMorfologica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return infMorfologicaRep.findByDiccionario(diccionario);
  }

  public InfMorfologica crear(Long diccionarioId, InfMorfologica infMorfologica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    infMorfologica.setDiccionario(diccionario);

    return infMorfologicaRep.save(infMorfologica);
  }

  public InfMorfologica actualizar(Long infMorfologicaId, InfMorfologica infMorfologica) {
    InfMorfologica infMorfologicaActual = infMorfologicaRep.findById(infMorfologicaId).orElse(null);
    infMorfologicaActual.setNombre(infMorfologica.getNombre());
    infMorfologicaActual.setDescripcion(infMorfologica.getDescripcion());

    final InfMorfologica infMorfologicaActualizada = infMorfologicaRep.save(infMorfologicaActual);
    return infMorfologicaActualizada;
  }

  public Boolean eliminar(Long infMorfologicaId) {
    InfMorfologica infMorfologica = infMorfologicaRep.findById(infMorfologicaId).orElse(null);

    infMorfologicaRep.delete(infMorfologica);
    return true;
  }
}