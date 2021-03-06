package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class ArticuloController {

  public static final String ARTICULO_NO_ENCONTRADO = "No existe el articulo con el id -> ";

  @Autowired
  private ArticuloService articuloSrv;

  @GetMapping("/diccionario/{diccionarioId}/articulo/{articuloId}")
  public Articulo buscarPorId(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @PathVariable(value = "articuloId") Long articuloId) {
    return articuloSrv.buscarPorId(articuloId);
  }

  @GetMapping("/diccionario/{diccionarioId}/articulo")
  public List<Articulo> buscarPorDiccionario(@PathVariable(value = "diccionarioId") Long diccionarioId)
      throws ResourceNotFoundException {
    List<Articulo> listaArticulo = articuloSrv.buscarPorDiccionario(diccionarioId);
    if (listaArticulo == null) {
      String message = DiccionarioController.DICCIONARIO_NO_ENCONTRADO + diccionarioId;
      throw new ResourceNotFoundException(message);
    }
    return listaArticulo;
  }

  @PostMapping("/diccionario/{diccionarioId}/articulo")
  public Articulo crear(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody Articulo articulo) {
    return articuloSrv.crear(diccionarioId, articulo);
  }

  @PutMapping("/diccionario/{diccionarioId}/articulo/{articuloId}")
  public Articulo actualizar(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @PathVariable(value = "articuloId") Long articuloId, @Valid @RequestBody Articulo articulo) {
    return articuloSrv.actualizar(diccionarioId, articuloId, articulo);
  }
}