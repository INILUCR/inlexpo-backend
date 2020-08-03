package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.InfMorfologica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.InfMorfologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class InfMorfologicaController {

  @Autowired
  private InfMorfologicaService infMorfologicaSrv;

  @GetMapping("/diccionario/{diccionarioId}/infMorfologica")
  public List<InfMorfologica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<InfMorfologica> listaInfMorfologicas = infMorfologicaSrv.buscarPorDiccionario(diccionarioId);
    if (listaInfMorfologicas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaInfMorfologicas;
  }

  @PostMapping("/diccionario/{diccionarioId}/infMorfologica")
  public InfMorfologica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody InfMorfologica infMorfologica) {
    return infMorfologicaSrv.crear(diccionarioId, infMorfologica);
  }
}