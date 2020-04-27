package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.SubGrmDiccionarioNuevo;
import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGrmDiccionario;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.CatGramaticalService;
import com.inil.inlexpo.inlexpobackend.service.DiccionarioService;
import com.inil.inlexpo.inlexpobackend.service.SubGramaticalService;
import com.inil.inlexpo.inlexpobackend.service.SubGrmDiccionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class SubGrmDiccionarioController {

  @Autowired
  private SubGrmDiccionarioService subGrmDiccionarioService;
  @Autowired
  private SubGramaticalService subGramaticalService;
  @Autowired
  private CatGramaticalService catGramaticalService;
  @Autowired
  private DiccionarioService diccionarioService;


  @PostMapping("/diccionario/subGramatical/varias")
  public ArrayList<SubGrmDiccionarioNuevo> crear (@Valid @RequestBody ArrayList<SubGrmDiccionarioNuevo> listaSubGrmDicNuevo)
          throws ResourceNotFoundException {
    try {
      if (listaSubGrmDicNuevo.size() > 0) {
        Diccionario diccionario = diccionarioService.buscarPorId(listaSubGrmDicNuevo.get(0).getDiccionarioId());
        for (SubGrmDiccionarioNuevo subGrmDiccionarioNuevo: listaSubGrmDicNuevo) {
          CatGramatical catGramatical = catGramaticalService.buscarPorId(subGrmDiccionarioNuevo.getCatGramaticalId());
          SubGramatical subGramatical = subGramaticalService.buscarPorId(subGrmDiccionarioNuevo.getSubGramaticalId());

          SubGrmDiccionario subGrmDiccionario = new SubGrmDiccionario(diccionario, catGramatical, subGramatical,
                  subGrmDiccionarioNuevo.getAbreviatura());
          subGrmDiccionarioService.crear(subGrmDiccionario);
        }
      }

      return listaSubGrmDicNuevo;
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }
}
