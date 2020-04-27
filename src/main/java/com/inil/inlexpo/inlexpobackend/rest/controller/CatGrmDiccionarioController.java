package com.inil.inlexpo.inlexpobackend.rest.controller;


import com.inil.inlexpo.inlexpobackend.dto.CatGrmDiccionarioNuevo;
import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.CatGrmDiccionario;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.CatGramaticalService;
import com.inil.inlexpo.inlexpobackend.service.CatGrmDiccionarioService;
import com.inil.inlexpo.inlexpobackend.service.DiccionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class CatGrmDiccionarioController {

  @Autowired
  private CatGrmDiccionarioService catGrmDiccionarioService;
  @Autowired
  private CatGramaticalService catGramaticalService;
  @Autowired
  private DiccionarioService diccionarioService;


  @PostMapping("/diccionario/catGramatical/varias")
  public ArrayList<CatGrmDiccionarioNuevo> crear (@Valid @RequestBody ArrayList<CatGrmDiccionarioNuevo> listaCatGrmDicNuevo)
          throws ResourceNotFoundException {
    try {
      if (listaCatGrmDicNuevo.size() > 0) {
        Diccionario diccionario = diccionarioService.buscarPorId(listaCatGrmDicNuevo.get(0).getDiccionarioId());
        for (CatGrmDiccionarioNuevo catGrmDiccionarioNuevo: listaCatGrmDicNuevo) {
          CatGramatical catGramatical = catGramaticalService.buscarPorId(catGrmDiccionarioNuevo.getCatGramaticalId());

          CatGrmDiccionario catGrmDiccionario = new CatGrmDiccionario(diccionario, catGramatical, catGrmDiccionarioNuevo.getAbreviatura());
          catGrmDiccionarioService.crear(catGrmDiccionario);
        }
      }

      return listaCatGrmDicNuevo;
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }
}
