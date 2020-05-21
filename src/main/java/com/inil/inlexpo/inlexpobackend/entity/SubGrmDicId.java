package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SubGrmDicId implements Serializable {

  @Column(name = "diccionario_id")
  private Long diccionarioId;
  @Column(name = "subcategoria_gramatical_id")
  private Long subGramaticalId;


  public SubGrmDicId() {}
  public SubGrmDicId(Long diccionarioId, Long subGramaticalId) {
    this.diccionarioId = diccionarioId;
    this.subGramaticalId = subGramaticalId;
  }

  /**********************************************************************************************************/

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

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    SubGrmDicId that = (SubGrmDicId) o;
    return Objects.equals(diccionarioId, that.diccionarioId) &&
      Objects.equals(subGramaticalId, that.subGramaticalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionarioId, subGramaticalId);
  }
}
