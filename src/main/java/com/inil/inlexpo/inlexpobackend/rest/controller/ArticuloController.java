package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class ArticuloController {

  public static final String ARTICULO_NO_ENCONTRADO = "No existe el articulo con el id -> ";

  @Autowired
  private ArticuloService articuloSrv;

  @GetMapping("/articulo/diccionario/{diccionarioId}")
  public List<Articulo> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {
    List<Articulo> listaArticulo = articuloSrv.buscarPorDiccionario(diccionarioId);
    if (listaArticulo == null) {
      String message = DiccionarioController.DICCIONARIO_NO_ENCONTRADO + diccionarioId;
      throw new ResourceNotFoundException(message);
    }
    return listaArticulo;
  }
}