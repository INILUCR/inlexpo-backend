package com.inil.inlexpo.inlexpobackend.dto;

public class DatosAcepcion {

  // Datos de la acepcion
  private String definicion;
  private Long prioridad;

  // Asociaciones de la acepcion
  private Long catGramaticalId;
  private Long subGramaticalId;
  // Informacion
  private Long infEtimologicaId;
  private Long infFoneticaId;
  private Long infMorfologicaId;
  private Long infOrtograficaId;
  // Marcacion
  private Long marDiacronicaId;
  private Long marDiatecnicaId;
  private Long marDiatopicaId;
  private Long marEstratificacionSocialId;
  private Long marFrecuenciaId;
  private Long marPragmaticaId;
  private Long marValoracionSocialId;

  public DatosAcepcion() {
  }

  public DatosAcepcion(String definicion, Long prioridad, Long catGramaticalId, Long subGramaticalId,
      Long infEtimologicaId, Long infFoneticaId, Long infMorfologicaId, Long infOrtograficaId, Long marDiacronicaId,
      Long marDiatecnicaId, Long marDiatopicaId, Long marEstratificacionSocial, Long marFrecuenciaId,
      Long marPragmaticaId, Long marValoracionSocialId) {
    this.definicion = definicion;
    this.prioridad = prioridad;

    this.catGramaticalId = catGramaticalId;
    this.subGramaticalId = subGramaticalId;

    this.infEtimologicaId = infEtimologicaId;
    this.infFoneticaId = infFoneticaId;
    this.infMorfologicaId = infMorfologicaId;
    this.infOrtograficaId = infOrtograficaId;

    this.marDiacronicaId = marDiacronicaId;
    this.marDiatecnicaId = marDiatecnicaId;
    this.marDiatopicaId = marDiatopicaId;
    this.marEstratificacionSocialId = marEstratificacionSocial;
    this.marFrecuenciaId = marFrecuenciaId;
    this.marPragmaticaId = marPragmaticaId;
    this.marValoracionSocialId = marValoracionSocialId;
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

  // Informacion
  public Long getInfEtimologicaId() {
    return infEtimologicaId;
  }

  public void setInfEtimologicaId(Long infEtimologicaId) {
    this.infEtimologicaId = infEtimologicaId;
  }

  public Long getInfFoneticaId() {
    return infFoneticaId;
  }

  public void setInfFoneticaId(Long infFoneticaId) {
    this.infFoneticaId = infFoneticaId;
  }

  public Long getInfMorfologicaId() {
    return infMorfologicaId;
  }

  public void setInfMorfologicaId(Long infMorfologicaId) {
    this.infMorfologicaId = infMorfologicaId;
  }

  public Long getInfOrtograficaId() {
    return infOrtograficaId;
  }

  public void setInfOrtograficaId(Long infOrtograficaId) {
    this.infOrtograficaId = infOrtograficaId;
  }

  // Marcacion
  public Long getMarDiacronicaId() {
    return marDiacronicaId;
  }

  public void setMarDiacronicaId(Long marDiacronicaId) {
    this.marDiacronicaId = marDiacronicaId;
  }

  public Long getMarDiatecnicaId() {
    return marDiatecnicaId;
  }

  public void setMarDiatecnicaId(Long marDiatecnicaId) {
    this.marDiatecnicaId = marDiatecnicaId;
  }

  public Long getMarDiatopicaId() {
    return marDiatopicaId;
  }

  public void setMarDiatopicaId(Long marDiatopicaId) {
    this.marDiatopicaId = marDiatopicaId;
  }

  public Long getMarEstratificacionSocialId() {
    return marEstratificacionSocialId;
  }

  public void setMarEstratificacionSocialId(Long marEstratificacionSocialId) {
    this.marEstratificacionSocialId = marEstratificacionSocialId;
  }

  public Long getMarFrecuenciaId() {
    return marFrecuenciaId;
  }

  public void setMarFrecuenciaId(Long marFrecuenciaId) {
    this.marFrecuenciaId = marFrecuenciaId;
  }

  public Long getMarPragmaticaId() {
    return marPragmaticaId;
  }

  public void setMarPragmaticaId(Long marPragmaticaId) {
    this.marPragmaticaId = marPragmaticaId;
  }

  public Long getMarValoracionSocialId() {
    return marValoracionSocialId;
  }

  public void setMarValoracionSocialId(Long marValoracionSocialId) {
    this.marValoracionSocialId = marValoracionSocialId;
  }
}