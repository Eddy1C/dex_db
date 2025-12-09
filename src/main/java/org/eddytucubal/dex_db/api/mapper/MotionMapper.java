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
    // ENTITY → RESPONSE DTO
    @Mapping(target = "id_movement", source = "idMovement")
    @Mapping(target = "fecha_hora_movimiento", source = "dateTimeMovement")
    @Mapping(target = "monto_movimiento", source = "amountMovement")
    @Mapping(target = "comercio_movimiento", source = "tradeMovement")
    @Mapping(target = "tipo_movimiento", source = "typeMovement")
    @Mapping(target = "descripcion_movimiento", source = "descriptionMovement")
    @Mapping(target = "id_api_movimiento", source = "externalIdMovement")
    @Mapping(target = "id_account_origin", source = "accountOrigin.idAccount")
    @Mapping(target = "id_account_destination", source = "accountDestination.idAccount")
    @Mapping(target = "id_category", source = "category.idCategory")
    MotionResponseDto toResponse(MotionEntity entity);


    // REQUEST DTO → ENTITY
    @Mapping(target = "idMovement", ignore = true)
    @Mapping(target = "accountOrigin", ignore = true)
    @Mapping(target = "accountDestination", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "dateTimeMovement", expression = "java(java.time.LocalDateTime.parse(dto.fecha_hora_movimiento()))")
    @Mapping(target = "amountMovement", expression = "java(Double.parseDouble(dto.monto_movimiento()))")
    MotionEntity toEntity(MotionRequestDto dto);

    // ACTUALIZAR ENTITY EXISTENTE
    @Mapping(target = "idMovement", ignore = true)
    @Mapping(target = "accountOrigin", ignore = true)
    @Mapping(target = "accountDestination", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "dateTimeMovement", expression = "java(java.time.LocalDateTime.parse(dto.fecha_hora_movimiento()))")
    @Mapping(target = "amountMovement", expression = "java(Double.parseDouble(dto.monto_movimiento()))")
    void updateEntityFromDto(MotionRequestDto dto, @MappingTarget MotionEntity entity);
}
