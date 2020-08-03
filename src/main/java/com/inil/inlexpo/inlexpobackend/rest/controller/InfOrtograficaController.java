package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.InfOrtografica;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.InfOrtograficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class InfOrtograficaController {

  @Autowired
  private InfOrtograficaService infOrtograficaSrv;

  @GetMapping("/diccionario/{diccionarioId}/infOrtografica")
  public List<InfOrtografica> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<InfOrtografica> listaInfOrtograficas = infOrtograficaSrv.buscarPorDiccionario(diccionarioId);
    if (listaInfOrtograficas == null) {
      throw new ResourceNotFoundException("");
    }
    return listaInfOrtograficas;
  }

  @PostMapping("/diccionario/{diccionarioId}/infOrtografica")
  public InfOrtografica crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody InfOrtografica infOrtografica) {
    return infOrtograficaSrv.crear(diccionarioId, infOrtografica);
  }
}