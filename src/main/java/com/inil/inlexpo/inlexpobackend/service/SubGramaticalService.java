package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.repository.SubGramaticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubGramaticalService {

  @Autowired
  private SubGramaticalRepository subGramaticalRep;
  @Autowired
  private CatGramaticalService catGramaticalSrv;

  public SubGramatical buscarPorId(Long subGramaticalId) {
    return subGramaticalRep.findById(subGramaticalId).orElse(null);
  }

  public List<SubGramatical> buscarPorCatGramatical(Long catGramaticalId) {
    CatGramatical catGramatical = catGramaticalSrv.buscarPorId(catGramaticalId);
    return subGramaticalRep.findByCatGramatical(catGramatical);
  }

  public SubGramatical crear(Long catGramaticalId, SubGramatical subGramatical) {
    // Pedimos el diccionario que tenmos que asociar
    CatGramatical catGramatical = catGramaticalSrv.buscarPorId(catGramaticalId);

    // Lo asociamos
    subGramatical.setCatGramatical(catGramatical);

    return subGramaticalRep.save(subGramatical);
  }

  public SubGramatical actualizar(Long subGramaticalId, SubGramatical subGramatical) {
    SubGramatical subGramaticalActual = subGramaticalRep.findById(subGramaticalId).orElse(null);
    subGramaticalActual.setNombre(subGramatical.getNombre());
    subGramaticalActual.setDescripcion(subGramatical.getDescripcion());
    subGramaticalActual.setAbreviatura(subGramatical.getAbreviatura());

    final SubGramatical subGramaticalActualizada = subGramaticalRep.save(subGramaticalActual);
    return subGramaticalActualizada;
  }

  public Boolean eliminar(Long subGramaticalId) {
    SubGramatical subGramatical = subGramaticalRep.findById(subGramaticalId).orElse(null);

    subGramaticalRep.delete(subGramatical);
    return true;
  }
}
