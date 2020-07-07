package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.DiccionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class DiccionarioController {

  public static final String DICCIONARIO_NO_ENCONTRADO = "No existe el diccionario con el id -> ";

  @Autowired
  private DiccionarioService diccionarioSrv;


  @GetMapping("/diccionario")
  public List<Diccionario> buscarTodos () {
    return  diccionarioSrv.buscarTodos();
  }

  @GetMapping("/diccionario/{diccionarioId}")
  public Diccionario buscarPorId (@PathVariable(value = "diccionarioId") Long diccionarioId) throws ResourceNotFoundException {
    Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
    if (diccionario == null) {
      String message = DICCIONARIO_NO_ENCONTRADO + diccionarioId;
      throw new ResourceNotFoundException(message);
    }
    return diccionario;
  }

  @PostMapping("/diccionario")
  public Diccionario crear (@Valid @RequestBody Diccionario diccionario) {
    return diccionarioSrv.crear(diccionario);
  }
}
