package com.inil.inlexpo.inlexpobackend.repository;

import com.inil.inlexpo.inlexpobackend.entity.CatGramatical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatGramaticalRepository extends JpaRepository<CatGramatical, Long> {
}
