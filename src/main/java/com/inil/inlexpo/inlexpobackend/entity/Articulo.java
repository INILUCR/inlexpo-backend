package com.inil.inlexpo.inlexpobackend.entity;

import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Articulo")
@Table(name = "articulo")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "lema")
public class Articulo {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "articulo_id")
  private Long id;

  @NaturalId
  @Column(name="lema", nullable = false, unique = true, length = 100)
  private String lema;
  @Column(name="publicado", columnDefinition = "boolean default false")
  private boolean publicado;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "diccionario_id")
  private Diccionario diccionario;


  public Articulo() {}
  public Articulo(@NotNull String lema, @NotNull boolean publicado) {
    this.lema = lema;
    this.publicado = publicado;
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

  public boolean isPublicado() {
    return publicado;
  }
  public void setPublicado(boolean publicado) {
    this.publicado = publicado;
  }

  public Diccionario getDiccionario() {
    return diccionario;
  }

  public void setDiccionario(Diccionario diccionario) {
    this.diccionario = diccionario;
  }

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    Articulo that = (Articulo) o;
    return Objects.equals(lema, that.lema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lema);
  }
}