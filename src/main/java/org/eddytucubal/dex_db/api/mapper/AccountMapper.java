package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.AccountRequestDto;
import org.eddytucubal.dex_db.dominio.dto.AccountResponseDto;
import org.eddytucubal.dex_db.persistence.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class, CategoryMapper.class })
public interface AccountMapper {
    @Mapping(target = "id_account", source = "idAccount")
    @Mapping(target = "nombre_cuenta", source = "nameAccount")
    @Mapping(target = "saldo_cuenta", source = "balanceAccount")
    @Mapping(target = "fecha_actualizacion_cuenta", source = "dateUpdateAccount")
    @Mapping(target = "banco_cuenta", source = "bankAccount")
    @Mapping(target = "tipo_cuenta", source = "typeAccount")
    @Mapping(target = "id_user", source = "user.idUser")
    @Mapping(target = "id_category", source = "category.idCategory")
    AccountResponseDto toResponse(AccountEntity accountEntity);

    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "nameAccount", source = "nombre_cuenta")
    @Mapping(target = "balanceAccount", source = "saldo_cuenta")
    @Mapping(target = "dateUpdateAccount", source = "fecha_actualizacion_cuenta")
    @Mapping(target = "bankAccount", source = "banco_cuenta")
    @Mapping(target = "typeAccount", source = "tipo_cuenta")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    AccountEntity toEntity(AccountRequestDto dto);

    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "nameAccount", source = "nombre_cuenta")
    @Mapping(target = "balanceAccount", source = "saldo_cuenta")
    @Mapping(target = "dateUpdateAccount", source = "fecha_actualizacion_cuenta")
    @Mapping(target = "bankAccount", source = "banco_cuenta")
    @Mapping(target = "typeAccount", source = "tipo_cuenta")
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDto(AccountRequestDto dto, @MappingTarget AccountEntity entity);
}