package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarDiacronica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarDiacronicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarDiacronicaController {

  @Autowired
  private MarDiacronicaService marDiacronicaSrv;

  @GetMapping("/diccionario/{diccionarioId}/marDiacronica")
  public List<MarDiacronica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarDiacronica> listaMarDiacronicas = marDiacronicaSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarDiacronicas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarDiacronicas;
  }

  @PostMapping("/diccionario/{diccionarioId}/marDiacronica")
  public MarDiacronica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarDiacronica marDiacronica) {
    return marDiacronicaSrv.crear(diccionarioId, marDiacronica);
  }

  @PutMapping("/marDiacronica/{marDiacronicaId}")
  public MarDiacronica actualizar(@PathVariable(value = "marDiacronicaId") Long marDiacronicaId,
      @Valid @RequestBody MarDiacronica marDiacronica) {
    return marDiacronicaSrv.actualizar(marDiacronicaId, marDiacronica);
  }

  @DeleteMapping("/marDiacronica/{marDiacronicaId}")
  public Boolean eliminar(@PathVariable(value = "marDiacronicaId") Long marDiacronicaId) {
    return marDiacronicaSrv.eliminar(marDiacronicaId);
  }
}