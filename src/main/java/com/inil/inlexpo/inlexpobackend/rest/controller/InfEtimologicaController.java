package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.InfEtimologica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.InfEtimologicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class InfEtimologicaController {

  @Autowired
  private InfEtimologicaService infEtimologicaSrv;

  @GetMapping("/diccionario/{diccionarioId}/infEtimologica")
  public List<InfEtimologica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<InfEtimologica> listaInfEtimologicas = infEtimologicaSrv.buscarPorDiccionario(diccionarioId);
    if (listaInfEtimologicas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaInfEtimologicas;
  }

  @PostMapping("/diccionario/{diccionarioId}/infEtimologica")
  public InfEtimologica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody InfEtimologica infEtimologica) {
    return infEtimologicaSrv.crear(diccionarioId, infEtimologica);
  }

  @PutMapping("/infEtimologica/{infEtimologicaId}")
  public InfEtimologica actualizar(@PathVariable(value = "infEtimologicaId") Long infEtimologicaId,
      @Valid @RequestBody InfEtimologica infEtimologica) {
    return infEtimologicaSrv.actualizar(infEtimologicaId, infEtimologica);
  }

  @DeleteMapping("/infEtimologica/{infEtimologicaId}")
  public Boolean eliminar(@PathVariable(value = "infEtimologicaId") Long infEtimologicaId) {
    return infEtimologicaSrv.eliminar(infEtimologicaId);
  }
}