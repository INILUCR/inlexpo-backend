package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.AcepcionDto;
import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.AcepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class AcepcionController {

  @Autowired
  private AcepcionService acepcionSrv;

  @GetMapping("/acepcion/articulo/{articuloId}")
  public List<AcepcionDto> buscarPorArticulo(@PathVariable(value = "articuloId") Long articuloId)
      throws ResourceNotFoundException {
    List<Acepcion> listaAcepcion = acepcionSrv.buscarPorArticulo(articuloId);
    if (listaAcepcion == null) {
      String message = ArticuloController.ARTICULO_NO_ENCONTRADO + articuloId;
      throw new ResourceNotFoundException(message);
    }
    return listaAcepcion.stream()
                        .map(acepcion -> convertToDto(acepcion))
                        .collect(Collectors.toList());
  }

  private AcepcionDto convertToDto(Acepcion acepcion) {
    return new AcepcionDto(acepcion.getId(), acepcion.getDefinicion(), acepcion.getPrioridad());
  }
}