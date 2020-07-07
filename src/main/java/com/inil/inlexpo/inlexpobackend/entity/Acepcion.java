package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Acepcion")
@Table(name = "acepcion")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Acepcion {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "acepcion_id")
  private Long id;

  @Column(name="definicion", nullable = false, length = 1000)
  private String definicion;
  @Column(name="prioridad", nullable = false)
  private Long prioridad;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "articulo_id")
  private Articulo articulo;

  public Acepcion() {}
  public Acepcion(@NotNull String definicion, @NotNull Long prioridad) {
    this.definicion = definicion;
    this.prioridad = prioridad;
  }

  /**********************************************************************************************************/

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getDefinicion() {
    return definicion;
  }
  public void setDefinicion(String definicion) {
    this.definicion = definicion;
  }

  public Long getPrioridad() {
    return prioridad;
  }
  public void setPrioridad(Long prioridad) {
    this.prioridad = prioridad;
  }

  public Articulo getArticulo() {
    return articulo;
  }

  public void setArticulo(Articulo articulo) {
    this.articulo = articulo;
  }

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof Acepcion)) return false;

    Acepcion that = (Acepcion) o;
    return id != null && id.equals(that.getId());
  }

  @Override
  public int hashCode() {
    return 31;
  }
}