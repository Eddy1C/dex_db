package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.LoginAttemptRequestDto;
import org.eddytucubal.dex_db.dominio.dto.LoginAttemptResponseDto;
import org.eddytucubal.dex_db.persistence.entity.LoginAttemptEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface LoginAttemptMapper {
    LoginAttemptMapper LOGIN_ATTEMPT_MAPPER = Mappers.getMapper(LoginAttemptMapper.class);

    LoginAttemptResponseDto toResponseDto(LoginAttemptEntity loginAttemptEntity);

    @Mapping(target = "idAttempt", ignore = true)
    @Mapping(target = "user", ignore = true)        // se setean en el service
    LoginAttemptEntity toEntityLoginAttempt(LoginAttemptRequestDto dto);

    @Mapping(target = "idAttempt", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntityFromDto(LoginAttemptRequestDto dto, @MappingTarget LoginAttemptEntity loginAttemptEntity);
}
