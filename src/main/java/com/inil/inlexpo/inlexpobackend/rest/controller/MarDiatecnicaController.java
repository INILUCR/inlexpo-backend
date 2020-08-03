package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarDiatecnica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarDiatecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarDiatecnicaController {

  @Autowired
  private MarDiatecnicaService marDiatecnicaSrv;

  @GetMapping("/diccionario/{diccionarioId}/marDiatecnica")
  public List<MarDiatecnica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarDiatecnica> listaMarDiatecnicas = marDiatecnicaSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarDiatecnicas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarDiatecnicas;
  }

  @PostMapping("/diccionario/{diccionarioId}/marDiatecnica")
  public MarDiatecnica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarDiatecnica marDiatecnica) {
    return marDiatecnicaSrv.crear(diccionarioId, marDiatecnica);
  }
}