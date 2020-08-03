package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarDiatopica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarDiatopicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarDiatopicaController {
  
  @Autowired
  private MarDiatopicaService marDiatopicaSrv;

  @GetMapping("/diccionario/{diccionarioId}/marDiatopica")
  public List<MarDiatopica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId) 
    throws ResourceNotFoundException {
    
    List<MarDiatopica> listaMarDiatopicas = marDiatopicaSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarDiatopicas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarDiatopicas;
  }

  @PostMapping("/diccionario/{diccionarioId}/marDiatopica")
  public MarDiatopica crear (@PathVariable(value = "diccionarioId") Long diccionarioId,
                              @Valid @RequestBody MarDiatopica marDiatopica) {
    return marDiatopicaSrv.crear(diccionarioId, marDiatopica);
  }
}