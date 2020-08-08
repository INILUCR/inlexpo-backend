package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.dto.DatosAcepcion;
import com.inil.inlexpo.inlexpobackend.entity.Acepcion;
import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.entity.InfEtimologica;
import com.inil.inlexpo.inlexpobackend.entity.InfFonetica;
import com.inil.inlexpo.inlexpobackend.entity.InfMorfologica;
import com.inil.inlexpo.inlexpobackend.entity.InfOrtografica;
import com.inil.inlexpo.inlexpobackend.entity.MarDiacronica;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatecnica;
import com.inil.inlexpo.inlexpobackend.entity.MarDiatopica;
import com.inil.inlexpo.inlexpobackend.entity.MarEstratificacionSocial;
import com.inil.inlexpo.inlexpobackend.entity.MarFrecuencia;
import com.inil.inlexpo.inlexpobackend.entity.MarPragmatica;
import com.inil.inlexpo.inlexpobackend.entity.MarValoracionSocial;
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
  private DiccionarioService diccionarioService;
  @Autowired
  private ArticuloService articuloSrv;
  @Autowired
  private CatGramaticalService catGramaticalService;
  @Autowired
  private SubGramaticalService subGramaticalService;
  // Informacion
  @Autowired
  private InfEtimologicaService infEtimologicaService;
  @Autowired
  private InfFoneticaService infFoneticaService;
  @Autowired
  private InfMorfologicaService infMorfologicaService;
  @Autowired
  private InfOrtograficaService infOrtograficaService;

  // Marcacion
  @Autowired
  private MarDiacronicaService marDiacronicaService;
  @Autowired
  private MarDiatecnicaService marDiatecnicaService;
  @Autowired
  private MarDiatopicaService marDiatopicaService;
  @Autowired
  private MarEstratificacionSocialService marEstratificacionSocialService;
  @Autowired
  private MarFrecuenciaService marFrecuenciaService;
  @Autowired
  private MarPragmaticaService marPragmaticaService;
  @Autowired
  private MarValoracionSocialService marValoracionSocialService;

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

    // Inicializamos el objeto de carga lenta
    Long diccionarioId = articulo.getDiccionario().getId();
    Diccionario diccionario = diccionarioService.buscarPorId(diccionarioId);
    acepcion.setDiccionario(diccionario);

    if (datosAcepcion.getCatGramaticalId() > 0) {
      CatGramatical catGramatical = catGramaticalService.buscarPorId(datosAcepcion.getCatGramaticalId());
      acepcion.setCatGramatical(catGramatical);

      if (datosAcepcion.getSubGramaticalId() > 0) {
        SubGramatical subGramatical = subGramaticalService.buscarPorId(datosAcepcion.getSubGramaticalId());
        acepcion.setSubGramatical(subGramatical);
      }
    }

    // Informacion
    if (datosAcepcion.getInfEtimologicaId() > 0) {
      InfEtimologica infEtimologica = infEtimologicaService.buscarPorId(datosAcepcion.getInfEtimologicaId());
      acepcion.setInfEtimologica(infEtimologica);
    }

    if (datosAcepcion.getInfFoneticaId() > 0) {
      InfFonetica infFonetica = infFoneticaService.buscarPorId(datosAcepcion.getInfFoneticaId());
      acepcion.setInfFonetica(infFonetica);
    }

    if (datosAcepcion.getInfMorfologicaId() > 0) {
      InfMorfologica infMorfologica = infMorfologicaService.buscarPorId(datosAcepcion.getInfMorfologicaId());
      acepcion.setInfMorfologica(infMorfologica);
    }

    if (datosAcepcion.getInfOrtograficaId() > 0) {
      InfOrtografica infOrtografica = infOrtograficaService.buscarPorId(datosAcepcion.getInfOrtograficaId());
      acepcion.setInfOrtografica(infOrtografica);
    }

    // Marcacion
    if (datosAcepcion.getMarDiacronicaId() > 0) {
      MarDiacronica marDiacronica = marDiacronicaService.buscarPorId(datosAcepcion.getMarDiacronicaId());
      acepcion.setMarDiacronica(marDiacronica);
    }

    if (datosAcepcion.getMarDiatecnicaId() > 0) {
      MarDiatecnica marDiatecnica = marDiatecnicaService.buscarPorId(datosAcepcion.getMarDiatecnicaId());
      acepcion.setMarDiatecnica(marDiatecnica);
    }

    if (datosAcepcion.getMarDiatopicaId() > 0) {
      MarDiatopica marDiatopica = marDiatopicaService.buscarPorId(datosAcepcion.getMarDiatopicaId());
      acepcion.setMarDiatopica(marDiatopica);
    }

    if (datosAcepcion.getMarEstratificacionSocialId() > 0) {
      MarEstratificacionSocial marEstratificacionSocial = marEstratificacionSocialService
          .buscarPorId(datosAcepcion.getMarEstratificacionSocialId());
      acepcion.setMarEstratificacionSocial(marEstratificacionSocial);
    }

    if (datosAcepcion.getMarFrecuenciaId() > 0) {
      MarFrecuencia marFrecuencia = marFrecuenciaService.buscarPorId(datosAcepcion.getMarFrecuenciaId());
      acepcion.setMarFrecuencia(marFrecuencia);
    }

    if (datosAcepcion.getMarPragmaticaId() > 0) {
      MarPragmatica marPragmatica = marPragmaticaService.buscarPorId(datosAcepcion.getMarPragmaticaId());
      acepcion.setMarPragmatica(marPragmatica);
    }

    if (datosAcepcion.getMarValoracionSocialId() > 0) {
      MarValoracionSocial marValoracionSocial = marValoracionSocialService
          .buscarPorId(datosAcepcion.getMarValoracionSocialId());
      acepcion.setMarValoracionSocial(marValoracionSocial);
    }

    return acepcionRep.save(acepcion);
  }
}