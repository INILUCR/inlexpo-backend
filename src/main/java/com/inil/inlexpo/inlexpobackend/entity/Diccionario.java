package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity(name = "Diccionario")
@Table(name = "diccionario")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "nombre")
public class Diccionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "diccionario_id")
  private Long id;

  @NaturalId
  @Column(name="nombre", nullable = false, unique = true)
  private String nombre;
  @Column(name="descripcion", nullable = false, length = 1000)
  private String descripcion;
  @Column(name="tipo", nullable = false, length = 20)
  private String tipo;
  /** private String editor; **/
  @Column(columnDefinition = "boolean default false")
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

  public boolean isPublicado() {
    return publicado;
  }
  public void setPublicado(boolean publicado) {
    this.publicado = publicado;
  }

  /**********************************************************************************************************/

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

  /**********************************************************************************************************/

  public void addCatGramatical(CatGramatical catGramatical, String abreviatura) {
    CatGrmDiccionario catGrmDiccionario = new CatGrmDiccionario(this, catGramatical, abreviatura);
    listaCatGrmDic.add(catGrmDiccionario);
  }

  public void removeCatGramatical(CatGramatical catGramatical) {
    for (Iterator<CatGrmDiccionario> iterator = listaCatGrmDic.iterator(); iterator.hasNext(); ) {
      CatGrmDiccionario catGrmDiccionario = iterator.next();

      if (catGrmDiccionario.getDiccionario().equals(this) &&
        catGrmDiccionario.getCatGramatical().equals(catGramatical)) {
          iterator.remove();
          catGrmDiccionario.setDiccionario(null);
          catGrmDiccionario.setCatGramatical(null);
      }
    }
  }


  public void addSubGramatical(SubGramatical subGramatical, String abreviatura) {
    SubGrmDiccionario subGrmDiccionario = new SubGrmDiccionario(this, subGramatical, abreviatura);
    listaSubGrmDic.add(subGrmDiccionario);
  }

  public void removeSubGramatical(SubGramatical subGramatical) {
    for (Iterator<SubGrmDiccionario> iterator = listaSubGrmDic.iterator(); iterator.hasNext(); ) {
      SubGrmDiccionario subGrmDiccionario = iterator.next();

      if (subGrmDiccionario.getDiccionario().equals(this) &&
        subGrmDiccionario.getSubGramatical().equals(subGramatical)) {
          iterator.remove();
          subGrmDiccionario.setDiccionario(null);
          subGrmDiccionario.setSubGramatical(null);
      }
    }
  }

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Diccionario that = (Diccionario) o;
    return Objects.equals(nombre, that.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre);
  }
}
