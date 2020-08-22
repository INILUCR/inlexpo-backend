package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.repository.CatGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatGramaticalService {

  @Autowired
  private CatGramaticalRepository catGramaticalRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public CatGramatical buscarPorId(Long catGramaticalId) {
    return catGramaticalRep.findById(catGramaticalId).orElse(null);
  }

  public List<CatGramatical> buscarPorDiccionario(Long diccionarioId) {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    return catGramaticalRep.findByDiccionario(diccionario);
  }

  public CatGramatical crear(Long diccionarioId, CatGramatical catGramatical) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    catGramatical.setDiccionario(diccionario);

    return catGramaticalRep.save(catGramatical);
  }

  public CatGramatical actualizar(Long catGramaticalId, CatGramatical catGramatical) {
    CatGramatical catGramaticalActual = catGramaticalRep.findById(catGramaticalId).orElse(null);
    catGramaticalActual.setNombre(catGramatical.getNombre());
    catGramaticalActual.setDescripcion(catGramatical.getDescripcion());
    catGramaticalActual.setAbreviatura(catGramatical.getAbreviatura());

    final CatGramatical catGramaticalActualizada = catGramaticalRep.save(catGramaticalActual);
    return catGramaticalActualizada;
  }

  public Boolean eliminar(Long catGramaticalId) {
    CatGramatical catGramatical = catGramaticalRep.findById(catGramaticalId).orElse(null);

    catGramaticalRep.delete(catGramatical);
    return true;
  }
}