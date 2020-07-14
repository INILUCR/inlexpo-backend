package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Articulo")
@Table(name = "articulo")
// @NaturalIdCache
// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "lema")
public class Articulo {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "articulo_id")
  private Long id;

  /* @NaturalId */
  @Column(name="lema", nullable = false, length = 100)
  private String lema;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "diccionario_id")
  @JsonIgnore
  private Diccionario diccionario;


  public Articulo() {}
  public Articulo(@NotNull String lema) {
    this.lema = lema;
  }

  /**********************************************************************************************************/

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getLema() {
    return lema;
  }
  public void setLema(String lema) {
    this.lema = lema;
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
  //   if (this == o) return true;

  //   if (o == null || getClass() != o.getClass())
  //     return false;

  //   Articulo that = (Articulo) o;
  //   return Objects.equals(lema, that.lema);
  // }

  // @Override
  // public int hashCode() {
  //   return Objects.hash(lema);
  // }
}