package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.dto.InfGramaticalDto;
import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.exception.ResourceNotFoundException;
import com.inil.inlexpo.inlexpobackend.service.CatGramaticalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class CatGramaticalController {
  
  @Autowired
  private CatGramaticalService catGrmSrv;
  @Autowired
  private ModelMapper modelMapper;


  /*@GetMapping("/catGrm")
  public List<InfGramaticalDto> findAll () {
    return  catGrmSrv.findAll().stream()
            .map(c -> convertToDto(c))
            .collect(Collectors.toList());
  }

  @GetMapping("/catGrm/{id}")
  public InfGramaticalDto findById (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      return convertToDto(catGrmSrv.findById(id));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @PostMapping("/catGrm")
  public InfGramaticalDto create (@Valid @RequestBody InfGramaticalDto cDto) {
    CatGramatical c = convertToEntity(cDto);
    return convertToDto(catGrmSrv.create(c));
  }

  @PutMapping("/catGrm/{id}")
  public InfGramaticalDto update (@PathVariable(value = "id") Long id,
                                @Valid @RequestBody InfGramaticalDto cDto) throws ResourceNotFoundException {
    CatGramatical cDet = convertToEntity(cDto);
    try {
      return convertToDto(catGrmSrv.update(id, cDet));
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @DeleteMapping("/catGrm/{id}")
  public void delete (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      catGrmSrv.delete(id);
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }

  @GetMapping("/catGramatical/{id}/subGrm")
  public CatGramatical findByIdWithSubGrm (@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
    try {
      return catGrmSrv.buscarPorId(id);
    } catch (ResourceNotFoundException ex) {
      throw ex;
    }
  }*/

  @GetMapping("/catGramatical/subGramatical")
  public List<CatGramatical> buscarTodosConSubcategoriasAsociadas () {
    return  catGrmSrv.buscarTodos();
  }
}
