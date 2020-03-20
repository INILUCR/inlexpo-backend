package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CatGrmDicId implements Serializable {

  @Column(name = "id_diccionario")
  private Long diccionarioId;
  @Column(name = "id_categoria_gramatical")
  private Long catGramaticalId;


  public CatGrmDicId() {}
  public CatGrmDicId(Long diccionarioId, Long catGramaticalId) {
    this.diccionarioId = diccionarioId;
    this.catGramaticalId = catGramaticalId;
  }


  public Long getDiccionarioId() {
    return diccionarioId;
  }
  public void setDiccionarioId(Long diccionarioId) {
    this.diccionarioId = diccionarioId;
  }

  public Long getCatGramaticalId() {
    return catGramaticalId;
  }
  public void setCatGramaticalId(Long catGramaticalId) {
    this.catGramaticalId = catGramaticalId;
  }


  @Override
  public boolean equals(Object o) {
    boolean isEquals = false;
    if (this == o) {
      isEquals = true;
    } else {
      if (o != null || (getClass() == o.getClass())) {
        CatGrmDicId other = (CatGrmDicId) o;
        isEquals = Objects.equals(this.diccionarioId, other.diccionarioId) &&
                Objects.equals(this.catGramaticalId, other.catGramaticalId);
      }
    }
    return isEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionarioId, catGramaticalId);
  }
}
