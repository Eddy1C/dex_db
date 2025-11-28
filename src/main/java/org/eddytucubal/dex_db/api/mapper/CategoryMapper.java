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
    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDto toResponse(CategoryEntity categoryEntity);

    @Mapping(target = "idCategory", ignore = true)
    @Mapping(target = "user", ignore = true)        // se setean en el service
    CategoryEntity toEntity(CategoryRequestDto dto);

    @Mapping(target = "idCategory", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateFromDto(CategoryRequestDto dto, @MappingTarget CategoryEntity entity);

}
