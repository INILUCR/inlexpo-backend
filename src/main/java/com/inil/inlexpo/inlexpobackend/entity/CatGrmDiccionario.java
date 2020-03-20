package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "diccionario_categoria_gramatical")
public class CatGrmDiccionario {

  @EmbeddedId
  private CatGrmDicId id;

  @NotNull
  @Column(name = "abreviatura")
  private String abreviatura;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_diccionario", insertable = false, updatable = false)
  private Diccionario diccionario;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_categoria_gramatical", insertable = false, updatable = false)
  private CatGramatical catGramatical;


  public CatGrmDiccionario() {}
  public CatGrmDiccionario(Diccionario diccionario, CatGramatical catGramatical, String abreviatura) {
    this.diccionario = diccionario;
    this.catGramatical = catGramatical;
    this.abreviatura = abreviatura;
    this.id = new CatGrmDicId(diccionario.getId(), catGramatical.getId());
  }


  public Diccionario getDiccionario() {
    return diccionario;
  }
  public void setDiccionario(Diccionario diccionario) {
    this.diccionario = diccionario;
  }

  public CatGramatical getCatGramatical() {
    return catGramatical;
  }
  public void setCatGramatical(CatGramatical catGramatical) {
    this.catGramatical = catGramatical;
  }


  @Override
  public boolean equals(Object o) {
    boolean isEquals = false;
    if (this == o) {
      isEquals =  true;
    } else {
      if (o != null || (getClass() == o.getClass())) {
        CatGrmDiccionario other = (CatGrmDiccionario) o;
        isEquals = diccionario != null && Objects.equals(diccionario, other.diccionario) &&
                catGramatical != null && Objects.equals(catGramatical, other.catGramatical);
      }
    }
    return isEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionario, catGramatical);
  }
}
