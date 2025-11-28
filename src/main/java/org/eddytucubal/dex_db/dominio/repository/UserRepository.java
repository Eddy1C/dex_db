package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
