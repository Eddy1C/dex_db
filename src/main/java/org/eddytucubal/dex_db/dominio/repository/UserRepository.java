package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
