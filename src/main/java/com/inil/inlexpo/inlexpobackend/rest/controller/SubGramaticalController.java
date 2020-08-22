package com.inil.inlexpo.inlexpobackend.rest.controller;

import java.util.List;

import javax.validation.Valid;

import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.SubGramaticalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class SubGramaticalController {
  @Autowired
  private SubGramaticalService subGramaticalSrv;

  @GetMapping("/catGramatical/{catGramaticalId}/subGramatical")
  public List<SubGramatical> buscarPorCatGramatical(@PathVariable(value = "catGramaticalId") Long catGramaticalId)
      throws ResourceNotFoundException {

    List<SubGramatical> listaSubGramaticales = subGramaticalSrv.buscarPorCatGramatical(catGramaticalId);
    if (listaSubGramaticales == null) {
      throw new ResourceNotFoundException("");
    }
    return listaSubGramaticales;
  }

  @PostMapping("/catGramatical/{catGramaticalId}/subGramatical")
  public SubGramatical crear(@PathVariable(value = "catGramaticalId") Long catGramaticalId,
      @Valid @RequestBody SubGramatical subGramatical) {
    return subGramaticalSrv.crear(catGramaticalId, subGramatical);
  }

  @PutMapping("/subGramatical/{subGramaticalId}")
  public SubGramatical actualizar(@PathVariable(value = "subGramaticalId") Long subGramaticalId,
      @Valid @RequestBody SubGramatical subGramatical) {
    return subGramaticalSrv.actualizar(subGramaticalId, subGramatical);
  }

  @DeleteMapping("/subGramatical/{subGramaticalId}")
  public Boolean eliminar(@PathVariable(value = "subGramaticalId") Long subGramaticalId) {
    return subGramaticalSrv.eliminar(subGramaticalId);
  }
}
