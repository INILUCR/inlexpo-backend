package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "diccionario_subcategoria_gramatical")
public class SubGrmDiccionario {

  @EmbeddedId
  private SubGrmDicId id;

  @NotNull
  @Column(name = "abreviatura")
  private String abreviatura;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_diccionario", insertable = false, updatable = false)
  private Diccionario diccionario;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_subcategoria_gramatical", insertable = false, updatable = false)
  private SubGramatical subGramatical;


  public SubGrmDiccionario() {}
  public SubGrmDiccionario(Diccionario diccionario, SubGramatical subGramatical, String abreviatura) {
    this.diccionario = diccionario;
    this.subGramatical = subGramatical;
    this.abreviatura = abreviatura;
    this.id = new SubGrmDicId(diccionario.getId(), subGramatical.getId());
  }


  public Diccionario getDiccionario() {
    return diccionario;
  }
  public void setDiccionario(Diccionario diccionario) {
    this.diccionario = diccionario;
  }

  public SubGramatical getSubGramatical() {
    return subGramatical;
  }
  public void setSubGramatical(SubGramatical subGramatical) {
    this.subGramatical = subGramatical;
  }


  @Override
  public boolean equals(Object o) {
    boolean isEquals = false;
    if (this == o) {
      isEquals =  true;
    } else {
      if (o != null || (getClass() == o.getClass())) {
        SubGrmDiccionario other = (SubGrmDiccionario) o;
        isEquals = diccionario != null && Objects.equals(diccionario, other.diccionario) &&
                subGramatical != null && Objects.equals(subGramatical, other.subGramatical);
      }
    }
    return isEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionario, subGramatical);
  }
}
