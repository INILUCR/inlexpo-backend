package com.inil.inlexpo.inlexpobackend.repository;

import com.inil.inlexpo.inlexpobackend.entity.SubGrmDicId;
import com.inil.inlexpo.inlexpobackend.entity.SubGrmDiccionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubGrmDiccionarioRepository extends JpaRepository<SubGrmDiccionario, SubGrmDicId> {
}
