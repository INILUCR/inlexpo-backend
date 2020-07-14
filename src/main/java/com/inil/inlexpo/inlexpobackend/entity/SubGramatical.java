package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "SubGramatical")
@Table(name = "subcategoria_gramatical")
// @NaturalIdCache
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
// property = "nombre")
public class SubGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "subcategoria_gramatical_id")
  private Long id;

  /* @NaturalId */
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;
  @Column(name = "abreviatura", nullable = false, length = 20)
  private String abreviatura;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "categoria_gramatical_id")
  @JsonIgnore
  private CatGramatical catGramatical;

  public SubGramatical() {}
  public SubGramatical(@NotNull String nombre, @NotNull String descripcion, @NotNull String abreviatura) {
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

  public CatGramatical getCatGramatical() {
    return catGramatical;
  }
  public void setCatGramatical(CatGramatical catGramatical) {
    this.catGramatical = catGramatical;
  }

  /**********************************************************************************************************/

  // @Override
  // public boolean equals(Object o) {
  //   if (this == o)
  //     return true;
  //   if (o == null || getClass() != o.getClass())
  //     return false;
  //   SubGramatical that = (SubGramatical) o;
  //   return Objects.equals(nombre, that.nombre);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(nombre);
  // }
}
