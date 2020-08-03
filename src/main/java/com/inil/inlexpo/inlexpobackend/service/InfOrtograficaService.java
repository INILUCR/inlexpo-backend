package com.inil.inlexpo.inlexpobackend.service;

import java.util.List;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfOrtografica;
import com.inil.inlexpo.inlexpobackend.repository.InfOrtograficaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfOrtograficaService {
  
  @Autowired
  private InfOrtograficaRepository infOrtograficaRep;
  @Autowired
  private DiccionarioService diccionarioSrv;

  public InfOrtografica buscarPorId(Long infOrtograficaId) {
    return infOrtograficaRep.findById(infOrtograficaId).orElse(null);
  }

  public List<InfOrtografica> buscarPorDiccionario(Long diccionarioId) {
		Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
		return infOrtograficaRep.findByDiccionario(diccionario);
	}

  public InfOrtografica crear(Long diccionarioId, InfOrtografica infOrtografica) {
    // Pedimos el diccionario que tenmos que asociar
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);

    // Lo asociamos
    infOrtografica.setDiccionario(diccionario);

    return infOrtograficaRep.save(infOrtografica);
  }
}