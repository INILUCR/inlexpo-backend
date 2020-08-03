package com.inil.inlexpo.inlexpobackend.dto;

public class DatosAcepcion {
  
  // Datos de la acepcion
  private String definicion;
  private Long prioridad;

  // Asociaciones de la acepcion
  private Long catGramaticalId;
  private Long subGramaticalId;

  public DatosAcepcion() {}
  public DatosAcepcion(String definicion, Long prioridad, Long catGramaticalId, Long subGramaticalId) {
    this.definicion = definicion;
    this.prioridad = prioridad;

    this.catGramaticalId = catGramaticalId;
    this.subGramaticalId = subGramaticalId;
  }

  public String getDefinicion() {
    return definicion;
  }
  public void setDefinicion(String definicion) {
    this.definicion = definicion;
  }

  public Long getPrioridad() {
    return prioridad;
  }
  public void setPrioridad(Long prioridad) {
    this.prioridad = prioridad;
  }

  public Long getCatGramaticalId() {
    return catGramaticalId;
  }
  public void setCatGramaticalId(Long catGramaticalId) {
    this.catGramaticalId = catGramaticalId;
  }

  public Long getSubGramaticalId() {
    return subGramaticalId;
  }
  public void setSubGramaticalId(Long subGramaticalId) {
    this.subGramaticalId = subGramaticalId;
  }
}