package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.repository.DiccionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiccionarioService {

  @Autowired
  private DiccionarioRepository diccionarioRep;

  public List<Diccionario> buscarTodos() {
    return diccionarioRep.findAll();
  }

  public Diccionario buscarPorId(Long id) {
    return diccionarioRep.findById(id).orElse(null);
  }

  public Diccionario crear(Diccionario diccionario) {
    return diccionarioRep.save(diccionario);
  }

  public Diccionario actualizar(Long diccionarioId, Diccionario diccionario) {
    Diccionario diccionarioActual = diccionarioRep.findById(diccionarioId).orElse(null);
    diccionarioActual.setNombre(diccionario.getNombre());
    diccionarioActual.setDescripcion(diccionario.getDescripcion());
    diccionarioActual.setTipo(diccionario.getTipo());

    final Diccionario diccionarioActualizado = diccionarioRep.save(diccionarioActual);
    return diccionarioActualizado;
  }

  /*
   * public boolean delete (Long id) throws ResourceNotFoundException {
   * Diccionario d = diccionarioRep.findById(id).orElseThrow(() -> new
   * ResourceNotFoundException("Diccionario: " + id)); diccionarioRep.delete(d);
   * return true; }
   */
}
