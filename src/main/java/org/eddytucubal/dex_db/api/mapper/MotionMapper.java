package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.MotionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.MotionResponseDto;
import org.eddytucubal.dex_db.persistence.entity.MotionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { AccountMapper.class, CategoryMapper.class })
public interface MotionMapper {
    MotionMapper MOTION_MAPPER = Mappers.getMapper(MotionMapper.class);

    MotionResponseDto toResponse(MotionEntity motionEntity);

    @Mapping(target = "idMovement", ignore = true)
    @Mapping(target = "accountOrigin", ignore = true)
    @Mapping(target = "accountDestination", ignore = true)
    @Mapping(target = "category", ignore = true)
    MotionEntity toEntity(MotionRequestDto dto);

    @Mapping(target = "idMovement", ignore = true)
    @Mapping(target = "accountOrigin", ignore = true)
    @Mapping(target = "accountDestination", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDto(MotionRequestDto dto, @MappingTarget MotionEntity motionEntity);
}
