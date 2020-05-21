package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "CatGrmDiccionario")
@Table(name = "diccionario_categoria_gramatical")
public class CatGrmDiccionario {

  @EmbeddedId
  private CatGrmDicId id;

  @Column(name = "abreviatura", nullable = false)
  private String abreviatura;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("diccionarioId")
  private Diccionario diccionario;
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("catGramaticalId")
  private CatGramatical catGramatical;


  public CatGrmDiccionario() {}
  public CatGrmDiccionario(@NotNull Diccionario diccionario, @NotNull CatGramatical catGramatical, @NotNull String abreviatura) {
    this.diccionario = diccionario;
    this.catGramatical = catGramatical;
    this.id = new CatGrmDicId(diccionario.getId(), catGramatical.getId());

    this.abreviatura = abreviatura;
  }

  /**********************************************************************************************************/

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

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    CatGrmDiccionario that = (CatGrmDiccionario) o;
    return Objects.equals(diccionario, that.diccionario) &&
      Objects.equals(catGramatical, that.catGramatical);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionario, catGramatical);
  }
}
