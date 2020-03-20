package com.inil.inlexpo.inlexpobackend.dto;

public class DiccionarioDto {

  private Long id;
  private String nombre;
  private String descripcion;
  private String tipo;


  public DiccionarioDto() {}
  public DiccionarioDto(Long id, String nombre, String descripcion, String tipo) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.tipo = tipo;
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

  public String getTipo() {
    return tipo;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
}
