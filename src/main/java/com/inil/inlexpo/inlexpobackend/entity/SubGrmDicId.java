package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubGrmDicId implements Serializable {

  @Column(name = "id_diccionario")
  private Long diccionarioId;
  @Column(name = "id_subcategoria_gramatical")
  private Long subGramaticalId;


  public SubGrmDicId() {}
  public SubGrmDicId(Long diccionarioId, Long subGramaticalId) {
    this.diccionarioId = diccionarioId;
    this.subGramaticalId = subGramaticalId;
  }


  public Long getDiccionarioId() {
    return diccionarioId;
  }
  public void setDiccionarioId(Long diccionarioId) {
    this.diccionarioId = diccionarioId;
  }

  public Long getSubGramaticalId() {
    return subGramaticalId;
  }
  public void setSubGramaticalId(Long subGramaticalId) {
    this.subGramaticalId = subGramaticalId;
  }


  @Override
  public boolean equals(Object o) {
    boolean isEquals = false;
    if (this == o) {
      isEquals = true;
    } else {
      if (o != null || (getClass() == o.getClass())) {
        SubGrmDicId other = (SubGrmDicId) o;
        isEquals = Objects.equals(this.diccionarioId, other.diccionarioId) &&
                Objects.equals(this.subGramaticalId, other.subGramaticalId);
      }
    }
    return isEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionarioId, subGramaticalId);
  }
}
