package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "CatGramatical")
@Table(name = "categoria_gramatical")
// @NaturalIdCache
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "nombre")
public class CatGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "categoria_gramatical_id")
  private Long id;

  @NaturalId
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;
  @Column(name = "abreviatura", nullable = false, length = 20)
  private String abreviatura;
  
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "diccionario_id")
  @JsonIgnore
  private Diccionario diccionario;

  public CatGramatical() {}
  public CatGramatical(@NotNull String nombre, @NotNull String descripcion, @NotNull String abreviatura) {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.abreviatura = abreviatura;
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

  public String getAbreviatura() {
    return abreviatura;
  }
  public void setAbreviatura(String abreviatura) {
    this.abreviatura = abreviatura;
  }

  public Diccionario getDiccionario() {
    return diccionario;
  }
  public void setDiccionario(Diccionario diccionario) {
    this.diccionario = diccionario;
  }

  /**********************************************************************************************************/

  // @Override
  // public boolean equals(Object o) {
  //   if (this == o)
  //     return true;
  //   if (o == null || getClass() != o.getClass())
  //     return false;
  //   CatGramatical that = (CatGramatical) o;
  //   return Objects.equals(nombre, that.nombre);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(nombre);
  // }
}
