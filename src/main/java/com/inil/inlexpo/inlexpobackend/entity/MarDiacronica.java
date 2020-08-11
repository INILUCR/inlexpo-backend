package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "MarDiacronica")
@Table(name = "marcacion_diacronica")
public class MarDiacronica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "marcacion_diacronica_id")
  private Long id;

  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "diccionario_id")
  @JsonIgnore
  private Diccionario diccionario;

  public MarDiacronica() {
  }

  public MarDiacronica(@NotNull String nombre, @NotNull String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }

  /**********************************************************************************************************/

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

  public Diccionario getDiccionario() {
    return diccionario;
  }

  public void setDiccionario(Diccionario diccionario) {
    this.diccionario = diccionario;
  }
}