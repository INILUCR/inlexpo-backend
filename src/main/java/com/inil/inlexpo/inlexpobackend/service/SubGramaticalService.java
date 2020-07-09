package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.repository.SubGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubGramaticalService {

  @Autowired
  private SubGramaticalRepository subGrmRep;
  @Autowired
  private CatGramaticalService catGrmSrv;


  public List<SubGramatical> buscarTodos() {
    return subGrmRep.findAll();
  }

  public SubGramatical buscarPorId(Long id) throws ResourceNotFoundException {
    return subGrmRep.findById(id).orElseThrow(() -> new ResourceNotFoundException("Subcategoria Gramatical: " + id));
  }

  public SubGramatical crear(Long catGramaticalId, SubGramatical subGramatical) {
    // Pedimos el diccionario que tenmos que asociar
    CatGramatical catGramatical = catGrmSrv.buscarPorId(catGramaticalId);

    // Lo asociamos
    subGramatical.setCatGramatical(catGramatical);

    return subGrmRep.save(subGramatical);
  }
}
