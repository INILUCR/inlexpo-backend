package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.dto.DatosAcepcion;
import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import com.inil.inlexpo.inlexpobackend.repository.AcepcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcepcionService {

  @Autowired
  private AcepcionRepository acepcionRep;
  @Autowired
  private ArticuloService articuloSrv;
  @Autowired
  private CatGramaticalService  catGramaticalService;
  @Autowired
  private SubGramaticalService subGramaticalService;

  public List<Acepcion> buscarPorArticulo(Long articuloId) {
    Articulo articulo = articuloSrv.buscarPorId(articuloId);
    return acepcionRep.findByArticuloOrderByPrioridad(articulo);
  }

  public Acepcion crear(Long articuloId, DatosAcepcion datosAcepcion) {
    // Construimos la acepcion con los datos respectivos
    Acepcion acepcion = new Acepcion(datosAcepcion.getDefinicion(), datosAcepcion.getPrioridad());

    // Pedimos las asociaciones y las asociamos
    Articulo articulo = articuloSrv.buscarPorId(articuloId);
    acepcion.setArticulo(articulo);
    
    if (datosAcepcion.getCatGramaticalId() > 0) {
      CatGramatical catGramatical = catGramaticalService.buscarPorId(datosAcepcion.getCatGramaticalId());
      acepcion.setCatGramatical(catGramatical);

      if (datosAcepcion.getSubGramaticalId() > 0) {
        SubGramatical subGramatical = subGramaticalService.buscarPorId(datosAcepcion.getSubGramaticalId());
        acepcion.setSubGramatical(subGramatical);
      }
    }

    return acepcionRep.save(acepcion);
  }
}