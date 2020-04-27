package com.inil.inlexpo.inlexpobackend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subcategoria_gramatical")
public class SubGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_subcategoria_gramatical")
  private Long id;

  @NotNull
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @NotNull
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;

  @OneToMany(mappedBy = "subGramatical", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SubGrmDiccionario> listaSubGrmDic = new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_categoria_gramatical")
  @JsonBackReference
  private CatGramatical catGramatical;


  public SubGramatical() {}
  public SubGramatical(@NotNull String nombre, @NotNull String descripcion) {
    this.nombre = nombre;
    this.descripcion = descripcion;
  }


  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }
  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public CatGramatical getCatGramatical() {
    return catGramatical;
  }
  public void setCatGramatical(CatGramatical catGramatical) {
    this.catGramatical = catGramatical;
  }


  public SubGrmDiccionario addDiccionario(Diccionario diccionario, CatGramatical catGramatical, String abreviatura) {
    SubGrmDiccionario subGrmDic = new SubGrmDiccionario(diccionario, catGramatical, this, abreviatura);
    listaSubGrmDic.add(subGrmDic);
    diccionario.getListaSubGrmDic().add(subGrmDic);
    return subGrmDic;
  }
  public void removeDiccionario(SubGrmDiccionario subGrmDic, Diccionario diccionario, CatGramatical catGramatical) {
    listaSubGrmDic.remove(subGrmDic);
    diccionario.getListaSubGrmDic().remove(subGrmDic);
    catGramatical.getListaSubGrmDic().remove(subGrmDic);
    // Vamos a dejarlo asi a ver si hace falta lo de los nulos
  }
}
