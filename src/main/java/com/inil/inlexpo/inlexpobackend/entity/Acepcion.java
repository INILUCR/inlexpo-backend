package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Acepcion")
@Table(name = "acepcion")
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Acepcion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acepcion_id")
  private Long id;

  @Column(name = "definicion", nullable = false, length = 1000)
  private String definicion;
  @Column(name = "prioridad", nullable = false)
  private Long prioridad;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "articulo_id")
  @JsonIgnore
  private Articulo articulo;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "categoria_gramatical_id")
  private CatGramatical catGramatical;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "subcategoria_gramatical_id")
  private SubGramatical subGramatical;

  // Informacion
  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "informacion_etimologica_id")
  private InfEtimologica infEtimologica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "informacion_fonetica_id")
  private InfFonetica infFonetica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "informacion_morfologica_id")
  private InfMorfologica infMorfologica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "informacion_ortografica_id")
  private InfOrtografica infOrtografica;

  // Marcacion
  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_diacronica_id")
  private MarDiacronica marDiacronica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_diatecnica_id")
  private MarDiatecnica marDiatecnica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_diatopica_id")
  private MarDiatopica marDiatopica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_estratificacion_social_id")
  private MarEstratificacionSocial marEstratificacionSocial;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_frecuencia_id")
  private MarFrecuencia marFrecuencia;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_pragmatica_id")
  private MarPragmatica marPragmatica;

  @ManyToOne(fetch = FetchType.EAGER, optional = true)
  @JoinColumn(name = "marcacion_valoracion_social_id")
  private MarValoracionSocial marValoracionSocial;

  public Acepcion() {
  }

  public Acepcion(@NotNull String definicion, @NotNull Long prioridad) {
    this.definicion = definicion;
    this.prioridad = prioridad;
  }

  /**********************************************************************************************************/

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Articulo getArticulo() {
    return articulo;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  public CatGramatical getCatGramatical() {
    return catGramatical;
  }

  public void setCatGramatical(CatGramatical catGramatical) {
    this.catGramatical = catGramatical;
  }

  public SubGramatical getSubGramatical() {
    return subGramatical;
  }

  public void setSubGramatical(SubGramatical subGramatical) {
    this.subGramatical = subGramatical;
  }

  // Informacion
  public InfEtimologica getInfEtimologica() {
    return infEtimologica;
  }

  public void setInfEtimologica(InfEtimologica infEtimologica) {
    this.infEtimologica = infEtimologica;
  }

  public InfFonetica getInfFonetica() {
    return infFonetica;
  }

  public void setInfFonetica(InfFonetica infFonetica) {
    this.infFonetica = infFonetica;
  }

  public InfMorfologica getInfMorfologica() {
    return infMorfologica;
  }

  public void setInfMorfologica(InfMorfologica infMorfologica) {
    this.infMorfologica = infMorfologica;
  }

  public InfOrtografica getInfOrtografica() {
    return infOrtografica;
  }

  public void setInfOrtografica(InfOrtografica infOrtografica) {
    this.infOrtografica = infOrtografica;
  }

  // Marcacion
  public MarDiacronica getMarDiacronica() {
    return marDiacronica;
  }

  public void setMarDiacronica(MarDiacronica marDiacronica) {
    this.marDiacronica = marDiacronica;
  }

  public MarDiatecnica getMarDiatecnica() {
    return marDiatecnica;
  }

  public void setMarDiatecnica(MarDiatecnica marDiatecnica) {
    this.marDiatecnica = marDiatecnica;
  }

  public MarDiatopica getMarDiatopica() {
    return marDiatopica;
  }

  public void setMarDiatopica(MarDiatopica marDiatopica) {
    this.marDiatopica = marDiatopica;
  }

  public MarEstratificacionSocial getMarEstratificacionSocial() {
    return marEstratificacionSocial;
  }

  public void setMarEstratificacionSocial(MarEstratificacionSocial marEstratificacionSocial) {
    this.marEstratificacionSocial = marEstratificacionSocial;
  }

  public MarFrecuencia getMarFrecuencia() {
    return marFrecuencia;
  }

  public void setMarFrecuencia(MarFrecuencia marFrecuencia) {
    this.marFrecuencia = marFrecuencia;
  }

  public MarPragmatica getMarPragmatica() {
    return marPragmatica;
  }

  public void setMarPragmatica(MarPragmatica marPragmatica) {
    this.marPragmatica = marPragmatica;
  }

  public MarValoracionSocial getMarValoracionSocial() {
    return marValoracionSocial;
  }

  public void setMarValoracionSocial(MarValoracionSocial marValoracionSocial) {
    this.marValoracionSocial = marValoracionSocial;
  }

  /**********************************************************************************************************/

  // @Override
  // public boolean equals(Object o) {
  // if (this == o) return true;

  // if (!(o instanceof Acepcion)) return false;

  // Acepcion that = (Acepcion) o;
  // return id != null && id.equals(that.getId());
  // }

  // @Override
  // public int hashCode() {
  // return 31;
  // }
}