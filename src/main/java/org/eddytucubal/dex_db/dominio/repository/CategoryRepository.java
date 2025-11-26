package org.eddytucubal.dex_db.dominio.repository;

import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
