package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.UserRequestDto;
import org.eddytucubal.dex_db.dominio.dto.UserResponseDto;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.mapstruct.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // ============================
    //      ENTITY → RESPONSE DTO
    // ============================
    @Mappings({
            @Mapping(source = "idUser", target = "id_user"),
            @Mapping(source = "nameUser", target = "nombre"),
            @Mapping(source = "lastNameUser", target = "apellido"),
            @Mapping(source = "emailUser", target = "correo"),
            @Mapping(source = "passwordUser", target = "contrasenia"),
            @Mapping(source = "dateIncomeUser", target = "fecha_creacion", qualifiedByName = "localDateToString"),
            @Mapping(source = "birthdateUser", target = "fecha_nacimiento", qualifiedByName = "localDateToString"),
            @Mapping(source = "genreUser", target = "genero_usuario")
    })
    UserResponseDto toResponse(UserEntity entity);


    // ============================
    //        REQUEST DTO → ENTITY
    // ============================
    @Mappings({
            @Mapping(target = "idUser", ignore = true),
            @Mapping(source = "nombre", target = "nameUser"),
            @Mapping(source = "apellido", target = "lastNameUser"),
            @Mapping(source = "correo", target = "emailUser"),
            @Mapping(source = "contrasenia", target = "passwordUser"),
            @Mapping(source = "fecha_creacion", target = "dateIncomeUser", qualifiedByName = "stringToLocalDate"),
            @Mapping(source = "fecha_nacimiento", target = "birthdateUser", qualifiedByName = "stringToLocalDate"),
            @Mapping(source = "genero_usuario", target = "genreUser"),
            @Mapping(target = "keyUser", ignore = true), // si luego quieres generarlo puedes hacerlo en el service
            @Mapping(target = "accounts", ignore = true)
    })
    UserEntity toEntity(UserRequestDto dto);


    // ====================================
    //      UPDATE (DTO → ENTITY EXISTENTE)
    // ====================================
    @Mappings({
            @Mapping(target = "idUser", ignore = true),
            @Mapping(source = "nombre", target = "nameUser"),
            @Mapping(source = "apellido", target = "lastNameUser"),
            @Mapping(source = "correo", target = "emailUser"),
            @Mapping(source = "contrasenia", target = "passwordUser"),
            @Mapping(source = "fecha_creacion", target = "dateIncomeUser", qualifiedByName = "stringToLocalDate"),
            @Mapping(source = "fecha_nacimiento", target = "birthdateUser", qualifiedByName = "stringToLocalDate"),
            @Mapping(source = "genero_usuario", target = "genreUser"),
            @Mapping(target = "accounts", ignore = true),
            @Mapping(target = "keyUser", ignore = true)
    })
    void updateEntityFromDto(UserRequestDto dto, @MappingTarget UserEntity entity);


    // ============================
    //      CONVERSORES FECHAS
    // ============================
    @Named("stringToLocalDate")
    public static LocalDate stringToLocalDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    @Named("localDateToString")
    public static String localDateToString(LocalDate date) {
        return date.format(DateTimeFormatter.ISO_DATE);
    }
}