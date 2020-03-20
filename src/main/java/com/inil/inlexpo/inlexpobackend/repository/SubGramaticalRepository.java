package com.inil.inlexpo.inlexpobackend.repository;

import com.inil.inlexpo.inlexpobackend.entity.SubGramatical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubGramaticalRepository extends JpaRepository<SubGramatical, Long> {
}
