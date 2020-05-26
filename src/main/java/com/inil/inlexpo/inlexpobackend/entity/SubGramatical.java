package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Objects;

@Entity(name = "SubGramatical")
@Table(name = "subcategoria_gramatical")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "nombre")
public class SubGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subcategoria_gramatical_id")
  private Long id;

  @NaturalId
  @Column(name = "nombre", nullable = false, unique = true)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "categoria_gramatical_id")
  private CatGramatical catGramatical;

  public SubGramatical() {
  }

  public SubGramatical(@NotNull String nombre, @NotNull String descripcion) {
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

  public CatGramatical getCatGramatical() {
    return catGramatical;
  }

  public void setCatGramatical(CatGramatical catGramatical) {
    this.catGramatical = catGramatical;
  }

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    SubGramatical that = (SubGramatical) o;
    return Objects.equals(nombre, that.nombre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombre);
  }
}
