package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarPragmatica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarPragmaticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarPragmaticaController {

  @Autowired
  private MarPragmaticaService marPragmaticaSrv;

  @GetMapping("/diccionario/{diccionarioId}/marPragmatica")
  public List<MarPragmatica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarPragmatica> listaMarPragmaticas = marPragmaticaSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarPragmaticas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarPragmaticas;
  }

  @PostMapping("/diccionario/{diccionarioId}/marPragmatica")
  public MarPragmatica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarPragmatica marPragmatica) {
    return marPragmaticaSrv.crear(diccionarioId, marPragmatica);
  }
}