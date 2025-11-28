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
    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    AccountResponseDto toResponse(AccountEntity accountEntity);

    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "user", ignore = true)        // se setean en el service
    @Mapping(target = "category", ignore = true)
    AccountEntity toEntity(AccountRequestDto dto);

    @Mapping(target = "idAccount", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEntityFromDto(AccountRequestDto dto, @MappingTarget AccountEntity entity);
}