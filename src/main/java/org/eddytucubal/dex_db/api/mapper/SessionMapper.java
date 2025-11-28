package org.eddytucubal.dex_db.api.mapper;


import org.eddytucubal.dex_db.dominio.dto.SessionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.SessionResponseDto;
import org.eddytucubal.dex_db.persistence.entity.SessionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class, CategoryMapper.class })
public interface SessionMapper {
    SessionMapper SESSION_MAPPER = Mappers.getMapper(SessionMapper.class);

    SessionResponseDto toResponse(SessionEntity sessionEntity);

    @Mapping(target = "idSession", ignore = true)
    @Mapping(target = "user", ignore = true)        // se setean en el service
    SessionEntity toEntity(SessionRequestDto dto);
}