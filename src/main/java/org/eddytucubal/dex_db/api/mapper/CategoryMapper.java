package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.CategoryRequestDto;
import org.eddytucubal.dex_db.dominio.dto.CategoryResponseDto;
import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface CategoryMapper {
    // ---------------- ENTITY → RESPONSE ----------------
    @Mapping(source = "idCategory", target = "id_category")
    @Mapping(source = "nameCategory", target = "nombre_categoria")
    @Mapping(source = "descriptionCategory", target = "descripcion_categoria")
    @Mapping(source = "typeCategory", target = "tipo_categoria")
    @Mapping(source = "user.idUser", target = "id_user")
    CategoryResponseDto toResponse(CategoryEntity entity);

    // ---------------- REQUEST → ENTITY ----------------
    @Mapping(target = "idCategory", ignore = true)
    @Mapping(source = "nombre_categoria", target = "nameCategory")
    @Mapping(source = "descripcion_categoria", target = "descriptionCategory")
    @Mapping(source = "tipo_categoria", target = "typeCategory")
    @Mapping(target = "user", ignore = true)   // Se setea en el service
    @Mapping(target = "movements", ignore = true) // List<MotionEntity> (siempre ignorar en DTO)
    CategoryEntity toEntity(CategoryRequestDto dto);

    // ---------------- UPDATE ----------------
    @Mapping(target = "idCategory", ignore = true)
    @Mapping(source = "nombre_categoria", target = "nameCategory")
    @Mapping(source = "descripcion_categoria", target = "descriptionCategory")
    @Mapping(source = "tipo_categoria", target = "typeCategory")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "movements", ignore = true)
    void updateFromDto(CategoryRequestDto dto, @MappingTarget CategoryEntity entity);
}