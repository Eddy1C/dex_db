package org.eddytucubal.dex_db.api.mapper;


import org.eddytucubal.dex_db.dominio.dto.SessionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.SessionResponseDto;
import org.eddytucubal.dex_db.persistence.entity.SessionEntity;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = { UserMapper.class, CategoryMapper.class })
public interface SessionMapper {
    // ============================
    //      ENTITY → RESPONSE DTO
    // ============================
    @Mapping(target = "id_session", source = "idSession")
    @Mapping(target = "dispositivo_sesion", source = "deviceSession")
    @Mapping(target = "sistema_operativo_sesion", source = "operatingSystemSession")
    @Mapping(target = "ip_dispositivo_sesion", source = "ipDeviceSession")
    @Mapping(target = "tokem_sesion", source = "tokenSession")
    @Mapping(target = "sesion_activa", source = "activeSession")
    @Mapping(target = "fecha_hora_inicio_sesion", source = "startDateTimeSession")
    @Mapping(target = "fecha_hora_cierre_sesion", source = "lastDateTimeSession")
    @Mapping(target = "fecha_expiracion_sesion", source = "expirationDateTimeSession")
    @Mapping(target = "plataforma_sesion", source = "sessionPlatform")
    @Mapping(target = "id_user", source = "user.idUser")
    SessionResponseDto toResponseDto(SessionEntity entity);

    // ============================
    //      REQUEST DTO → ENTITY
    // ============================
    @Mapping(target = "idSession", ignore = true)
    @Mapping(target = "user", source = "id_user", qualifiedByName = "mapUser")
    @Mapping(target = "deviceSession", source = "dispositivo_sesion")
    @Mapping(target = "operatingSystemSession", source = "sistema_operativo_sesion")
    @Mapping(target = "ipDeviceSession", source = "ip_dispositivo_sesion")
    @Mapping(target = "tokenSession", source = "tokem_sesion")
    @Mapping(target = "activeSession", source = "sesion_activa")
    @Mapping(target = "startDateTimeSession", source = "fecha_hora_inicio_sesion")
    @Mapping(target = "lastDateTimeSession", source = "fecha_hora_cierre_sesion")
    @Mapping(target = "expirationDateTimeSession", source = "fecha_expiracion_sesion")
    @Mapping(target = "sessionPlatform", source = "plataforma_sesion")
    SessionEntity toSessionEntity(SessionRequestDto dto);

    // ============================
    //   UPDATE EXISTING ENTITY
    // ============================
    @Mapping(target = "idSession", ignore = true)
    @Mapping(target = "user", ignore = true) // se setea en el service si se requiere cambiar
    @Mapping(target = "deviceSession", source = "dispositivo_sesion")
    @Mapping(target = "operatingSystemSession", source = "sistema_operativo_sesion")
    @Mapping(target = "ipDeviceSession", source = "ip_dispositivo_sesion")
    @Mapping(target = "tokenSession", source = "tokem_sesion")
    @Mapping(target = "activeSession", source = "sesion_activa")
    @Mapping(target = "startDateTimeSession", source = "fecha_hora_inicio_sesion")
    @Mapping(target = "lastDateTimeSession", source = "fecha_hora_cierre_sesion")
    @Mapping(target = "expirationDateTimeSession", source = "fecha_expiracion_sesion")
    @Mapping(target = "sessionPlatform", source = "plataforma_sesion")
    void updateEntityFromDto(SessionRequestDto dto, @MappingTarget SessionEntity entity);

    // ============================
    //      HELPER USER
    // ============================
    @Named("mapUser")
    default UserEntity mapUser(Long idUser) {
        if (idUser == null) return null;
        UserEntity u = new UserEntity();
        u.setIdUser(idUser);
        return u;
    }
}