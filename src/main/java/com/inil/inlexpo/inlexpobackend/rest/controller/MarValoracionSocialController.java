package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarValoracionSocial;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarValoracionSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarValoracionSocialController {

  @Autowired
  private MarValoracionSocialService marValoracionSocialSrv;

  @GetMapping("/diccionario/{diccionarioId}/marValoracionSocial")
  public List<MarValoracionSocial> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarValoracionSocial> listaMarValoracionSocials = marValoracionSocialSrv.buscarPorDiccionario(diccionarioId);
    if (listaMarValoracionSocials == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarValoracionSocials;
  }

  @PostMapping("/diccionario/{diccionarioId}/marValoracionSocial")
  public MarValoracionSocial crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarValoracionSocial marValoracionSocial) {
    return marValoracionSocialSrv.crear(diccionarioId, marValoracionSocial);
  }

  @PutMapping("/marValoracionSocial/{marValoracionSocialId}")
  public MarValoracionSocial actualizar(@PathVariable(value = "marValoracionSocialId") Long marValoracionSocialId,
      @Valid @RequestBody MarValoracionSocial marValoracionSocial) {
    return marValoracionSocialSrv.actualizar(marValoracionSocialId, marValoracionSocial);
  }

  @DeleteMapping("/marValoracionSocial/{marValoracionSocialId}")
  public Boolean eliminar(@PathVariable(value = "marValoracionSocialId") Long marValoracionSocialId) {
    return marValoracionSocialSrv.eliminar(marValoracionSocialId);
  }
}