package com.inil.inlexpo.inlexpobackend.dto;

import java.util.ArrayList;
import java.util.List;

public class InfGramaticalDto {

  private Long id;
  private String nombre;
  private String descripcion;
  private List<InfGramaticalDto> infGramaticalLista = new ArrayList<>();


  public InfGramaticalDto() {}
  public InfGramaticalDto(Long id, String nombre, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void addInfGramatical(InfGramaticalDto s) {
    infGramaticalLista.add(s);
  }
}
