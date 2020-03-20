package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.InfGramaticalDto;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.SubGramaticalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

public class SubGramaticalController {

  @Autowired
  private SubGramaticalService subGrmSrv;
  @Autowired
  private ModelMapper modelMapper;


  @GetMapping("/subGrm")
  public List<InfGramaticalDto> findAll () {
    return  subGrmSrv.findAll().stream()
            .map(s -> convertToDto(s))
            .collect(Collectors.toList());
  }

  @GetMapping("/subGrm/{id}")
  public InfGramaticalDto findById (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      return convertToDto(subGrmSrv.findById(id));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @PostMapping("/subGrm")
  public InfGramaticalDto create (@Valid @RequestBody InfGramaticalDto sDto) {
    SubGramatical s = convertToEntity(sDto);
    return convertToDto(subGrmSrv.create(s));
  }

  @PutMapping("/subGrm/{id}")
  public InfGramaticalDto update (@PathVariable(value = "id") Long id,
                                  @Valid @RequestBody InfGramaticalDto sDto) throws ResourceNotFoundException {
    SubGramatical sDet = convertToEntity(sDto);
    try {
      return convertToDto(subGrmSrv.update(id, sDet));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @DeleteMapping("/subGrm/{id}")
  public void delete (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      subGrmSrv.delete(id);
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  private InfGramaticalDto convertToDto(SubGramatical s) {
    return modelMapper.map(s, InfGramaticalDto.class);
  }
  private SubGramatical convertToEntity(InfGramaticalDto s) {
    return modelMapper.map(s, SubGramatical.class);
  }
}
