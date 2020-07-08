package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.AcepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class AcepcionController {

  @Autowired
  private AcepcionService acepcionSrv;

  @GetMapping("/acepcion/articulo/{articuloId}")
  public List<Acepcion> buscarPorArticulo(@PathVariable(value = "articuloId") Long articuloId)
      throws ResourceNotFoundException {
    
    List<Acepcion> listaAcepcion = acepcionSrv.buscarPorArticulo(articuloId);
    
    if (listaAcepcion == null) {
      String message = ArticuloController.ARTICULO_NO_ENCONTRADO + articuloId;
      throw new ResourceNotFoundException(message);
    }
    
    return listaAcepcion;
  }
}