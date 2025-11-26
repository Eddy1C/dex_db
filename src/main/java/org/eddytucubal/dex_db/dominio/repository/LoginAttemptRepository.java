package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.LoginAttemptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginAttemptRepository extends JpaRepository<LoginAttemptEntity, Long> {
}
