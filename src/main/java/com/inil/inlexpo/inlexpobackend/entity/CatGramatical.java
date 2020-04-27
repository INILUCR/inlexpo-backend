package com.inil.inlexpo.inlexpobackend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_gramatical")
public class CatGramatical {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria_gramatical")
  private Long id;

  @NotNull
  @Column(name = "nombre", nullable = false)
  private String nombre;
  @NotNull
  @Column(name = "descripcion", nullable = false, length = 1000)
  private String descripcion;

  @OneToMany(mappedBy = "catGramatical", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CatGrmDiccionario> listaCatGrmDic = new ArrayList<>();
  @OneToMany(mappedBy = "catGramatical", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<SubGramatical> listaSubGramatical = new ArrayList<>();
  @OneToMany(mappedBy = "catGramatical", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<SubGrmDiccionario> listaSubGrmDic = new ArrayList<>();


  public CatGramatical() {}
  public CatGramatical(@NotNull String nombre, @NotNull String descripcion) {
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

  public List<CatGrmDiccionario> getListaCatGrmDic() {
    return listaCatGrmDic;
  }
  public List<SubGramatical> getListaSubGramatical() {
    return listaSubGramatical;
  }

  public CatGrmDiccionario addDiccionario(Diccionario diccionario, String abreviatura) {
    CatGrmDiccionario catGrmDic = new CatGrmDiccionario(diccionario, this, abreviatura);
    listaCatGrmDic.add(catGrmDic);
    diccionario.getListaCatGrmDic().add(catGrmDic);
    return catGrmDic;
  }
  public void removeDiccionario(CatGrmDiccionario catGrmDic, Diccionario diccionario) {
    listaCatGrmDic.remove(catGrmDic);
    diccionario.getListaCatGrmDic().remove(catGrmDic);
    // Vamos a dejarlo asi a ver si hace falta lo de los nulos
  }

  public void addSubGrm(SubGramatical subGramatical) {
    listaSubGramatical.add(subGramatical);
    subGramatical.setCatGramatical(this);
  }
  public void removeSubGrm(SubGramatical subGramatical) {
    listaSubGramatical.remove(subGramatical);
    subGramatical.setCatGramatical(null);
  }

  public List<SubGrmDiccionario> getListaSubGrmDic() {
    return listaSubGrmDic;
  }
  public void setListaSubGrmDic(List<SubGrmDiccionario> listaSubGrmDic) {
    this.listaSubGrmDic = listaSubGrmDic;
  }
}
