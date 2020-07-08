package com.inil.inlexpo.inlexpobackend.service;

import com.inil.inlexpo.inlexpobackend.entity.Articulo;
import com.inil.inlexpo.inlexpobackend.entity.Diccionario;
import com.inil.inlexpo.inlexpobackend.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {

	@Autowired
	private ArticuloRepository articuloRep;
	@Autowired
	private DiccionarioService diccionarioSrv;

	public Articulo buscarPorId(Long articuloId) {
		return articuloRep.findById(articuloId).orElse(null);
	}

	public List<Articulo> buscarPorDiccionario(Long diccionarioId) {
		Diccionario diccionario = diccionarioSrv.buscarPorId(diccionarioId);
		return articuloRep.findByDiccionario(diccionario);
	}
}