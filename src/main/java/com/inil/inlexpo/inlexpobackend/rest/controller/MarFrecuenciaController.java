package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarFrecuencia;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarFrecuenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarFrecuenciaController {

  @Autowired
  private MarFrecuenciaService marFrecuenciaSrv;

  @GetMapping("/diccionario/{diccionarioId}/marFrecuencia")
  public List<MarFrecuencia> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarFrecuencia> listaMarFrecuencias = marFrecuenciaSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarFrecuencias == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarFrecuencias;
  }

  @PostMapping("/diccionario/{diccionarioId}/marFrecuencia")
  public MarFrecuencia crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarFrecuencia marFrecuencia) {
    return marFrecuenciaSrv.crear(diccionarioId, marFrecuencia);
  }

  @PutMapping("/marFrecuencia/{marFrecuenciaId}")
  public MarFrecuencia actualizar(@PathVariable(value = "marFrecuenciaId") Long marFrecuenciaId,
      @Valid @RequestBody MarFrecuencia marFrecuencia) {
    return marFrecuenciaSrv.actualizar(marFrecuenciaId, marFrecuencia);
  }

  @DeleteMapping("/marFrecuencia/{marFrecuenciaId}")
  public Boolean eliminar(@PathVariable(value = "marFrecuenciaId") Long marFrecuenciaId) {
    return marFrecuenciaSrv.eliminar(marFrecuenciaId);
  }
}