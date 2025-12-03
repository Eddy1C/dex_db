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
    // ======== RESPONSE (Entity → DTO) ==========
    @Mapping(target = "id_attempt", source = "idAttempt")
    @Mapping(target = "fecha_hora_intento_logueo",
            expression = "java( entity.getAttemptDateTime().toString() )")
    @Mapping(target = "exitoso_logueo", expression = "java( String.valueOf(entity.isSuccessful()) )")
    @Mapping(target = "razon_logueo", source = "reason")
    @Mapping(target = "direccion_ip_logueo", source = "ipAddress")
    @Mapping(target = "agente_usuario", source = "userAgent")
    @Mapping(target = "id_user", source = "user.idUser")
    LoginAttemptResponseDto toResponse(LoginAttemptEntity entity);


    // ======== REQUEST (Dto → Entity) ==========
    @Mapping(target = "idAttempt", ignore = true)
    @Mapping(target = "user", ignore = true)  // se setea en el service
    @Mapping(target = "attemptDateTime",
            expression = "java( java.time.LocalDateTime.parse(dto.fecha_hora_intento_logueo()) )")
    @Mapping(target = "successful",
            expression = "java( Boolean.parseBoolean(dto.exitoso_logueo()) )")
    @Mapping(target = "reason", source = "razon_logueo")
    @Mapping(target = "ipAddress", source = "direccion_ip_logueo")
    @Mapping(target = "userAgent", source = "agente_usuario")
    LoginAttemptEntity toEntity(LoginAttemptRequestDto dto);


    // ======== UPDATE (RequestDto → Entity EXISTENTE) ==========
    @Mapping(target = "idAttempt", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "attemptDateTime",
            expression = "java( java.time.LocalDateTime.parse(dto.fecha_hora_intento_logueo()) )")
    @Mapping(target = "successful",
            expression = "java( Boolean.parseBoolean(dto.exitoso_logueo()) )")
    @Mapping(target = "reason", source = "razon_logueo")
    @Mapping(target = "ipAddress", source = "direccion_ip_logueo")
    @Mapping(target = "userAgent", source = "agente_usuario")
    void updateEntityFromDto(LoginAttemptRequestDto dto, @MappingTarget LoginAttemptEntity entity);
}
