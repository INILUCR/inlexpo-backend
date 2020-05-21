package com.inil.inlexpo.inlexpobackend.rest.controller;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.service.CatGramaticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class CatGramaticalController {
  
  @Autowired
  private CatGramaticalService catGrmSrv;


  @GetMapping("/catGrm")
  public List<CatGramatical> buscarTodos () {
    return  catGrmSrv.buscarTodos();
  }

  @GetMapping("/catGrm/subGrm")
  public List<CatGramatical> buscarTodosConSubGrmAsociadas () {
    return  catGrmSrv.buscarTodos();
  }
}
