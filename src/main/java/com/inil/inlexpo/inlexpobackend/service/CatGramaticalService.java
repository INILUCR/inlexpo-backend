package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.repository.CatGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CatGramaticalService {

  @Autowired
  private CatGramaticalRepository catGrmRep;
  @PersistenceContext
  EntityManager entityManager;


  public List<CatGramatical> buscarTodos() {
    return catGrmRep.findAll();
  }

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

  public CatGramatical buscarPorId(Long id) throws ResourceNotFoundException {
    return catGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria Gramatical: " + id));
  }
}
