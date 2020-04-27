package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.repository.SubGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubGramaticalService {

  @Autowired
  private SubGramaticalRepository subGrmRep;


  /*public List<SubGramatical> findAll() {
    return subGrmRep.findAll();
  }*/

  public SubGramatical buscarPorId(Long id) throws ResourceNotFoundException {
    return subGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subcategoria Gramatical: " + id));
  }

  /*public SubGramatical create(SubGramatical s) {
    return subGrmRep.save(s);
  }

  public SubGramatical update(Long id, SubGramatical s) throws ResourceNotFoundException {
    SubGramatical sActual = subGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subcategoria Gramatical: " + id));
    sActual.setNombre(s.getNombre());
    sActual.setDescripcion(s.getDescripcion());
    sActual = subGrmRep.save(sActual);

    return sActual;
  }

  public boolean delete(Long id) throws ResourceNotFoundException {
    SubGramatical s = subGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subcategoria Gramatical: " + id));
    subGrmRep.delete(s);
    return true;
  }*/
}
