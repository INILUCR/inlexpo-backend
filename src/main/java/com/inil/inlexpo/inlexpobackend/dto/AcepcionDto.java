package com.inil.inlexpo.inlexpobackend.dto;

public class AcepcionDto {

  private Long id;
  private String definicion;
  private Long prioridad;

  public AcepcionDto(Long id, String definicion, Long prioridad) {
    this.id = id;
    this.definicion = definicion;
    this.prioridad = prioridad;
  }

  public Long getId() {
    return id;
  }

  public String getDefinicion() {
    return definicion;
  }

  public Long getPrioridad() {
    return prioridad;
  }
}