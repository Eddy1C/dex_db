package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.MotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotionRepository extends JpaRepository<MotionEntity, Long> {
}
