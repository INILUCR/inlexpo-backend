package com.inil.inlexpo.inlexpobackend.dto;

public class CatGrmDiccionarioNuevo {

  private Long diccionarioId;
  private Long catGramaticalId;
  private String abreviatura;

  public CatGrmDiccionarioNuevo() {}
  public CatGrmDiccionarioNuevo(Long diccionarioId, Long catGramaticalId, String abreviatura) {
    this.diccionarioId = diccionarioId;
    this.catGramaticalId = catGramaticalId;
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

  public String getAbreviatura() {
    return abreviatura;
  }
  public void setAbreviatura(String abreviatura) {
    this.abreviatura = abreviatura;
  }
}
