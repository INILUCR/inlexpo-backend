package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "CatGramatical")
@Table(name = "categoria_gramatical")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "nombre")
public class CatGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "categoria_gramatical_id")
  private Long id;

  @NaturalId
  @Column(name = "nombre", nullable = false, unique = true)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Transient
  private List<SubGramatical> listaSubGramatical = new ArrayList<>();

  public CatGramatical() {
  }

  public CatGramatical(@NotNull String nombre, @NotNull String descripcion) {
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

  public List<SubGramatical> getListaSubGramatical() {
    return listaSubGramatical;
  }

  public void setListaSubGramatical(List<SubGramatical> listaSubGramatical) {
    this.listaSubGramatical = listaSubGramatical;
  }

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CatGramatical that = (CatGramatical) o;
    return Objects.equals(nombre, that.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre);
  }
}
