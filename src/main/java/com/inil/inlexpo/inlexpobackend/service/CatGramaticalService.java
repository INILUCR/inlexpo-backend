package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.repository.CatGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatGramaticalService {

  @Autowired
  private CatGramaticalRepository catGrmRep;


  public List<CatGramatical> buscarTodos() {
    return catGrmRep.findAll();
  }

  public CatGramatical buscarPorId(Long id) throws ResourceNotFoundException {
    return catGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria Gramatical: " + id));
  }

  /*public CatGramatical create(CatGramatical c) {
    return catGrmRep.save(c);
  }

  public CatGramatical update(Long id, CatGramatical c) throws ResourceNotFoundException {
    CatGramatical cActual = catGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria Gramatical: " + id));
    cActual.setNombre(c.getNombre());
    cActual.setDescripcion(c.getDescripcion());
    cActual = catGrmRep.save(cActual);

    return cActual;
  }

  public boolean delete(Long id) throws ResourceNotFoundException {
    CatGramatical c = catGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria Gramatical: " + id));
    catGrmRep.delete(c);
    return true;
  }*/
}
