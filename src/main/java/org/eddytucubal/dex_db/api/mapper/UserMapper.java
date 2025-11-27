package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.UserRequestDto;
import org.eddytucubal.dex_db.dominio.dto.UserResponseDto;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "idUser", ignore = true)
    UserEntity toEntity(UserRequestDto dto);

    // De Entity → ResponseDto (para responder al cliente)
    UserResponseDto toResponse(UserEntity userEntity);
}
