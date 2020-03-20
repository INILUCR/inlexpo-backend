package com.inil.inlexpo.inlexpobackend.repository;

import com.inil.inlexpo.inlexpobackend.entity.CatGrmDicId;
import com.inil.inlexpo.inlexpobackend.entity.CatGrmDiccionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatGrmDiccionarioRepository extends JpaRepository<CatGrmDiccionario, CatGrmDicId> {
}
