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
  private CatGramaticalRepository catGrmRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public List<CatGramatical> buscarTodos() {
    return catGrmRep.findAll();
  }

  public CatGramatical buscarPorId(Long id) {
    return catGrmRep.findById(id).orElse(null);
  }

  public CatGramatical crear(Long diccionarioId, CatGramatical catGramatical) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    catGramatical.setDiccionario(diccionario);

    return catGrmRep.save(catGramatical);
  }
}

/* 
@PersistenceContext
EntityManager entityManager;

public List<CatGramatical> buscarTodosConSubGrmAsociadas() {
  List<CatGramatical> listaCatGrm = catGrmRep.findAll();

  for(CatGramatical catGramatical : listaCatGrm) {
    List<SubGramatical> listaSubGramatical = entityManager.createQuery(
      "select sg " +
      "from SubGramatical sg " +
      "where sg.catGramatical.id = :catGramaticalId", SubGramatical.class)
      .setParameter( "catGramaticalId", catGramatical.getId() )
      .getResultList();
    
    catGramatical.setListaSubGramatical(listaSubGramatical);
  }

  return listaCatGrm;
}
*/