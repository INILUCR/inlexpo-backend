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
  private SubGramaticalRepository subGrmRep;
  @Autowired
  private CatGramaticalService catGrmSrv;

  public SubGramatical buscarPorId(Long subGramaticalId) {
    return subGrmRep.findById(subGramaticalId).orElse(null);
  }

  public List<SubGramatical> buscarPorCatGramatical(Long catGramaticalId) {
		CatGramatical catGramatical = catGrmSrv.buscarPorId(catGramaticalId);
		return subGrmRep.findByCatGramatical(catGramatical);
	}

  public SubGramatical crear(Long catGramaticalId, SubGramatical subGramatical) {
    // Pedimos el diccionario que tenmos que asociar
    CatGramatical catGramatical = catGrmSrv.buscarPorId(catGramaticalId);

    // Lo asociamos
    subGramatical.setCatGramatical(catGramatical);

    return subGrmRep.save(subGramatical);
  }
}
