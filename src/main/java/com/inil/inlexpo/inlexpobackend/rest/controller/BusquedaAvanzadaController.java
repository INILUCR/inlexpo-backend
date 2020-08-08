package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.DatosAcepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.BusquedaAvanzadaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")
public class BusquedaAvanzadaController {

  @Autowired
  private BusquedaAvanzadaService busquedaAvanzadaSrv;

  // Esto no deberia ser asi pero fue lo unico que se me ocurrio
  @PostMapping("diccionario/{diccionarioId}/busquedaAvanzada")
  public List<Articulo> busquedaAvanzada(@PathVariable(value = "diccionarioId") Long diccionarioId,
      @Valid @RequestBody DatosAcepcion datosAcepcion) throws ResourceNotFoundException {

    return busquedaAvanzadaSrv.buscarPorFiltros(diccionarioId, datosAcepcion);
  }
}