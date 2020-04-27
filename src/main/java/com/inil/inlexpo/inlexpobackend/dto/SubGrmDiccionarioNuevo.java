package com.inil.inlexpo.inlexpobackend.dto;

public class SubGrmDiccionarioNuevo {

  private Long diccionarioId;
  private Long catGramaticalId;
  private Long subGramaticalId;
  private String abreviatura;

  public SubGrmDiccionarioNuevo() {}
  public SubGrmDiccionarioNuevo(Long diccionarioId, Long catGramaticalId, Long subGramaticalId, String abreviatura) {
    this.diccionarioId = diccionarioId;
    this.catGramaticalId = catGramaticalId;
    this.subGramaticalId = subGramaticalId;
    this.abreviatura = abreviatura;
  }

  public Long getDiccionarioId() {
    return diccionarioId;
  }
  public void setDiccionarioId(Long diccionarioId) {
    this.diccionarioId = diccionarioId;
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

  public String getAbreviatura() {
    return abreviatura;
  }
  public void setAbreviatura(String abreviatura) {
    this.abreviatura = abreviatura;
  }
}
