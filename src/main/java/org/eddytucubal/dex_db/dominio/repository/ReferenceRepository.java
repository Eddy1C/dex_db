package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.ReferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceRepository extends JpaRepository<ReferenceEntity, Long> {
}
