package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Diccionario")
@Table(name = "diccionario")
public class Diccionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "diccionario_id")
  private Long id;

  @Column(name = "nombre", nullable = false, unique = true)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;
  @Column(name = "tipo", nullable = false, length = 20)
  private String tipo;

  public Diccionario() {
  }

  public Diccionario(@NotNull String nombre, @NotNull String descripcion, @NotNull String tipo) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.tipo = tipo;
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

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
