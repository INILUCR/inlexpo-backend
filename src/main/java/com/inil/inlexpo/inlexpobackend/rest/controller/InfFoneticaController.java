package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.InfFonetica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.InfFoneticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class InfFoneticaController {

  @Autowired
  private InfFoneticaService infFoneticaSrv;

  @GetMapping("/diccionario/{diccionarioId}/infFonetica")
  public List<InfFonetica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<InfFonetica> listaInfFoneticas = infFoneticaSrv.buscarPorDiccionario(diccionarioId);
    if (listaInfFoneticas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaInfFoneticas;
  }

  @PostMapping("/diccionario/{diccionarioId}/infFonetica")
  public InfFonetica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody InfFonetica infFonetica) {
    return infFoneticaSrv.crear(diccionarioId, infFonetica);
  }
}