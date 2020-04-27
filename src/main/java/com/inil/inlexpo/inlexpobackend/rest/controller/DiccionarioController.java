package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.DiccionarioNuevo;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.service.DiccionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class DiccionarioController {

  @Autowired
  private DiccionarioService diccionarioSrv;
  @Autowired
  private ModelMapper modelMapper;


  @GetMapping("/diccionario")
  public List<DiccionarioNuevo> buscarTodos () {
    return  diccionarioSrv.buscarTodos().stream()
            .map(d -> convertToDto(d))
            .collect(Collectors.toList());
  }

  /*@GetMapping("/diccionarios/{id}")
  public DiccionarioNuevo findById (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      return convertToDto(diccionarioSrv.findById(id));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }*/

  @PostMapping("/diccionario")
  public DiccionarioNuevo crear (@Valid @RequestBody DiccionarioNuevo diccionarioNuevo) {
    Diccionario diccionario = convertToEntity(diccionarioNuevo);
    return convertToDto(diccionarioSrv.crear(diccionario));
  }

  /*@PutMapping("/diccionarios/{id}")
  public DiccionarioNuevo update (@PathVariable(value = "id") Long id,
                                @Valid @RequestBody DiccionarioNuevo dDto) throws ResourceNotFoundException {
    Diccionario dDet = convertToEntity(dDto);
    try {
      return convertToDto(diccionarioSrv.update(id, dDet));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @DeleteMapping("/diccionarios/{id}")
  public void delete (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      diccionarioSrv.delete(id);
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }*/

  private DiccionarioNuevo convertToDto(Diccionario d) {
    return modelMapper.map(d, DiccionarioNuevo.class);
  }
  private Diccionario convertToEntity(DiccionarioNuevo d) {
    return modelMapper.map(d, Diccionario.class);
  }
}
