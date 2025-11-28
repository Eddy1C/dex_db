package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.ReferenceRequestDto;
import org.eddytucubal.dex_db.dominio.dto.ReferenceResponseDto;
import org.eddytucubal.dex_db.persistence.entity.ReferenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface ReferenceMapper {

    ReferenceMapper REFERENCE_MAPPER = Mappers.getMapper(ReferenceMapper.class);

    ReferenceResponseDto toResponseDto(ReferenceEntity referenceEntity);

    @Mapping(target = "idUrl", ignore = true)
    @Mapping(target = "user", ignore = true)
    ReferenceEntity toEntityReference(ReferenceRequestDto dto);

    @Mapping(target = "idUrl", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntityFromDto(ReferenceRequestDto dto, @MappingTarget ReferenceEntity entity);
}
