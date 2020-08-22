package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.MarEstratificacionSocial;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.MarEstratificacionSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class MarEstratificacionSocialController {

  @Autowired
  private MarEstratificacionSocialService marEstratificacionSocialSrv;

  @GetMapping("/diccionario/{diccionarioId}/marEstratificacionSocial")
  public List<MarEstratificacionSocial> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {

    List<MarEstratificacionSocial> listaMarEstratificacionSocials = marEstratificacionSocialSrv
        .buscarPorDiccionario(diccionarioId);
    if (listaMarEstratificacionSocials == null) {
      throw new ResourceNotFoundException("");
    }
    return listaMarEstratificacionSocials;
  }

  @PostMapping("/diccionario/{diccionarioId}/marEstratificacionSocial")
  public MarEstratificacionSocial crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody MarEstratificacionSocial marEstratificacionSocial) {
    return marEstratificacionSocialSrv.crear(diccionarioId, marEstratificacionSocial);
  }

  @PutMapping("/marEstratificacionSocial/{marEstratificacionSocialId}")
  public MarEstratificacionSocial actualizar(
      @PathVariable(value = "marEstratificacionSocialId") Long marEstratificacionSocialId,
      @Valid @RequestBody MarEstratificacionSocial marEstratificacionSocial) {
    return marEstratificacionSocialSrv.actualizar(marEstratificacionSocialId, marEstratificacionSocial);
  }

  @DeleteMapping("/marEstratificacionSocial/{marEstratificacionSocialId}")
  public Boolean eliminar(@PathVariable(value = "marEstratificacionSocialId") Long marEstratificacionSocialId) {
    return marEstratificacionSocialSrv.eliminar(marEstratificacionSocialId);
  }
}