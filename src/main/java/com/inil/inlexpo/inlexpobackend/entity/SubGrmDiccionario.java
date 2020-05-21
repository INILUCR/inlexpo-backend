package com.inil.inlexpo.inlexpobackend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "SubGrmDiccionario")
@Table(name = "diccionario_subcategoria_gramatical")
public class SubGrmDiccionario {

  @EmbeddedId
  private SubGrmDicId id;

  @Column(name = "abreviatura", nullable = false)
  private String abreviatura;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("diccionarioId")
  private Diccionario diccionario;
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("subGramaticalId")
  private SubGramatical subGramatical;


  public SubGrmDiccionario() {}
  public SubGrmDiccionario(@NotNull Diccionario diccionario, @NotNull SubGramatical subGramatical, @NotNull String abreviatura) {
    this.diccionario = diccionario;
    this.subGramatical = subGramatical;
    this.id = new SubGrmDicId(diccionario.getId(), subGramatical.getId());

    this.abreviatura = abreviatura;
  }

  /**********************************************************************************************************/

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

  /**********************************************************************************************************/

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass())
      return false;

    SubGrmDiccionario that = (SubGrmDiccionario) o;
    return Objects.equals(diccionario, that.diccionario) &&
      Objects.equals(subGramatical, that.subGramatical);
  }

  @Override
  public int hashCode() {
    return Objects.hash(diccionario, subGramatical);
  }
}
