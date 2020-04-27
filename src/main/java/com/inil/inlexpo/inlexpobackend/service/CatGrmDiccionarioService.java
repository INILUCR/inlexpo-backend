package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.CatGrmDiccionario;
import com.inil.inlexpo.inlexpobackend.repository.CatGrmDiccionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatGrmDiccionarioService {

  @Autowired
  private CatGrmDiccionarioRepository catGrmDiccionarioRep;

  public CatGrmDiccionario crear(CatGrmDiccionario catGrmDiccionario) {
    return catGrmDiccionarioRep.save(catGrmDiccionario);
  }
}
