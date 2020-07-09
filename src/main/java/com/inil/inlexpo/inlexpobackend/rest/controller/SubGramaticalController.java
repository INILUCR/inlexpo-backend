package com.inil.inlexpo.inlexpobackend.rest.controller;

import java.util.List;

import javax.validation.Valid;

import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.service.SubGramaticalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/inlexpo")

public class SubGramaticalController {
  @Autowired
  private SubGramaticalService subGrmSrv;

  @GetMapping("/subGramatical")
  public List<SubGramatical> buscarTodos () {
    return  subGrmSrv.buscarTodos();
  }

  @PostMapping("/catGramatical/{catGramaticalId}/subGramatical")
  public SubGramatical crear (@PathVariable(value = "catGramaticalId") Long catGramaticalId,
                              @Valid @RequestBody SubGramatical subGramatical) {
    return subGrmSrv.crear(catGramaticalId, subGramatical);
  }
}
