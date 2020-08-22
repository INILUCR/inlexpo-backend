package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfFonetica;
import com.inil.inlexpo.inlexpobackend.repository.InfFoneticaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfFoneticaService {

  @Autowired
  private InfFoneticaRepository infFoneticaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public InfFonetica buscarPorId(Long infFoneticaId) {
    return infFoneticaRep.findById(infFoneticaId).orElse(null);
  }

  public List<InfFonetica> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return infFoneticaRep.findByDiccionario(diccionario);
  }

  public InfFonetica crear(Long diccionarioId, InfFonetica infFonetica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    infFonetica.setDiccionario(diccionario);

    return infFoneticaRep.save(infFonetica);
  }

  public InfFonetica actualizar(Long infFoneticaId, InfFonetica infFonetica) {
    InfFonetica infFoneticaActual = infFoneticaRep.findById(infFoneticaId).orElse(null);
    infFoneticaActual.setNombre(infFonetica.getNombre());
    infFoneticaActual.setDescripcion(infFonetica.getDescripcion());

    final InfFonetica infFoneticaActualizada = infFoneticaRep.save(infFoneticaActual);
    return infFoneticaActualizada;
  }

  public Boolean eliminar(Long infFoneticaId) {
    InfFonetica infFonetica = infFoneticaRep.findById(infFoneticaId).orElse(null);

    infFoneticaRep.delete(infFonetica);
    return true;
  }
}