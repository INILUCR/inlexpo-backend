package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CatGrmDicId implements Serializable {

  @Column(name = "diccionario_id")
  private Long diccionarioId;
  @Column(name = "categoria_gramatical_id")
  private Long catGramaticalId;


  public CatGrmDicId() {}
  public CatGrmDicId(Long diccionarioId, Long catGramaticalId) {
    this.diccionarioId = diccionarioId;
    this.catGramaticalId = catGramaticalId;
  }

  /**********************************************************************************************************/

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

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    CatGrmDicId that = (CatGrmDicId) o;
    return Objects.equals(diccionarioId, that.diccionarioId) &&
      Objects.equals(catGramaticalId, that.catGramaticalId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionarioId, catGramaticalId);
  }
}
