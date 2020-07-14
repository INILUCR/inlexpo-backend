package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.CatGramaticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class CatGramaticalController {
  
  @Autowired
  private CatGramaticalService catGrmSrv;

  @GetMapping("/diccionario/{diccionarioId}/catGramatical")
  public List<CatGramatical> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId) 
    throws ResourceNotFoundException {
    
    List<CatGramatical> listaCatGramaticales = catGrmSrv.buscarPorDiccionario(diccionarioId);
    if (listaCatGramaticales == null) {
      throw new ResourceNotFoundException("");
    }
    return listaCatGramaticales;
  }

  @PostMapping("/diccionario/{diccionarioId}/catGramatical")
  public CatGramatical crear (@PathVariable(value = "diccionarioId") Long diccionarioId,
                              @Valid @RequestBody CatGramatical catGramatical) {
    return catGrmSrv.crear(diccionarioId, catGramatical);
  }
}
