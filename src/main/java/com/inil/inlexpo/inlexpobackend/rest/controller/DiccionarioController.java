package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.DiccionarioDto;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
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


  @GetMapping("/diccionarios")
  public List<DiccionarioDto> findAll () {
    return  diccionarioSrv.findAll().stream()
            .map(d -> convertToDto(d))
            .collect(Collectors.toList());
  }

  @GetMapping("/diccionarios/{id}")
  public DiccionarioDto findById (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      return convertToDto(diccionarioSrv.findById(id));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @PostMapping("/diccionarios")
  public DiccionarioDto create (@Valid @RequestBody DiccionarioDto dDto) {
    Diccionario d = convertToEntity(dDto);
    return convertToDto(diccionarioSrv.create(d));
  }

  @PutMapping("/diccionarios/{id}")
  public DiccionarioDto update (@PathVariable(value = "id") Long id,
                                @Valid @RequestBody DiccionarioDto dDto) throws ResourceNotFoundException {
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
  }

  private DiccionarioDto convertToDto(Diccionario d) {
    return modelMapper.map(d, DiccionarioDto.class);
  }
  private Diccionario convertToEntity(DiccionarioDto d) {
    return modelMapper.map(d, Diccionario.class);
  }
}
