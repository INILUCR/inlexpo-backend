package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.SubGrmDiccionario;
import com.inil.inlexpo.inlexpobackend.repository.SubGrmDiccionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubGrmDiccionarioService {

  @Autowired
  private SubGrmDiccionarioRepository subGrmDiccionarioRep;

  public SubGrmDiccionario crear(SubGrmDiccionario subGrmDiccionario) {
    return subGrmDiccionarioRep.save(subGrmDiccionario);
  }
}
