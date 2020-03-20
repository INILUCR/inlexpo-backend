package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diccionario")
public class Diccionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_diccionario")
  private Long id;

  @NotNull
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @NotNull
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;
  @NotNull
  @Column(name = "tipo", nullable = false, length = 20)
  private String tipo;
  /** private String editor; **/
  @NotNull
  @Column(name = "publicado", columnDefinition = "boolean default false")
  private boolean publicado;

  @OneToMany(mappedBy = "diccionario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CatGrmDiccionario> listaCatGrmDic = new ArrayList<>();
  @OneToMany(mappedBy = "diccionario", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SubGrmDiccionario> listaSubGrmDic = new ArrayList<>();


  public Diccionario() {}
  public Diccionario(@NotNull String nombre, @NotNull String descripcion, @NotNull String tipo, @NotNull boolean publicado) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.tipo = tipo;
    this.publicado = publicado;
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

  public boolean isPublicado() {
    return publicado;
  }
  public void setPublicado(boolean publicado) {
    this.publicado = publicado;
  }

  public List<CatGrmDiccionario> getListaCatGrmDic() {
    return listaCatGrmDic;
  }
  public void setListaCatGrmDic(List<CatGrmDiccionario> listaCatGrmDic) {
    this.listaCatGrmDic = listaCatGrmDic;
  }

  public List<SubGrmDiccionario> getListaSubGrmDic() {
    return listaSubGrmDic;
  }
  public void setListaSubGrmDic(List<SubGrmDiccionario> listaSubGrmDic) {
    this.listaSubGrmDic = listaSubGrmDic;
  }
}
