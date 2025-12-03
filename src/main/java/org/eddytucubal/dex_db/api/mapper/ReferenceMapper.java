package org.eddytucubal.dex_db.api.mapper;

import org.eddytucubal.dex_db.dominio.dto.ReferenceRequestDto;
import org.eddytucubal.dex_db.dominio.dto.ReferenceResponseDto;
import org.eddytucubal.dex_db.persistence.entity.ReferenceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { UserMapper.class})
public interface ReferenceMapper {

    // ===================== ENTITY → RESPONSE =====================
    @Mapping(target = "id_url",           source = "idUrl")
    @Mapping(target = "url",              source = "url")
    @Mapping(target = "fecha_url",        source = "dateUrl")
    @Mapping(target = "tipo_busqueda_url", source = "searchTypeUrl")
    @Mapping(target = "tipo_fuente_url",  source = "sourceTypeUrl")
    @Mapping(target = "resumen_url",      source = "summaryUrl")
    @Mapping(target = "fecha_creado_url", source = "createdAtUrl")
    @Mapping(target = "fecha_actualizado_url", source = "updatedAtUrl")
    @Mapping(target = "id_user",          source = "user.idUser")
    ReferenceResponseDto toResponseDto(ReferenceEntity entity);

    // ===================== REQUEST → ENTITY =====================
    @Mapping(target = "idUrl", ignore = true)
    @Mapping(target = "url", source = "url")
    @Mapping(target = "dateUrl", expression = "java(java.time.LocalDate.parse(dto.fecha_url()))")
    @Mapping(target = "searchTypeUrl", source = "tipo_busqueda_url")
    @Mapping(target = "sourceTypeUrl",  source = "tipo_fuente_url")
    @Mapping(target = "summaryUrl",     source = "resumen_url")
    @Mapping(target = "createdAtUrl",   expression = "java(java.time.LocalDateTime.parse(dto.fecha_creado_url()))")
    @Mapping(target = "updatedAtUrl",   expression = "java(java.time.LocalDateTime.parse(dto.fecha_actualizado_url()))")
    @Mapping(target = "user", ignore = true) // se setea en el service
    ReferenceEntity toEntityReference(ReferenceRequestDto dto);

    // ===================== UPDATE =====================
    @Mapping(target = "idUrl", ignore = true)
    @Mapping(target = "url", source = "url")
    @Mapping(target = "dateUrl", expression = "java(java.time.LocalDate.parse(dto.fecha_url()))")
    @Mapping(target = "searchTypeUrl", source = "tipo_busqueda_url")
    @Mapping(target = "sourceTypeUrl",  source = "tipo_fuente_url")
    @Mapping(target = "summaryUrl",     source = "resumen_url")
    @Mapping(target = "createdAtUrl",   expression = "java(java.time.LocalDateTime.parse(dto.fecha_creado_url()))")
    @Mapping(target = "updatedAtUrl",   expression = "java(java.time.LocalDateTime.parse(dto.fecha_actualizado_url()))")
    @Mapping(target = "user", ignore = true)
    void updateEntityFromDto(ReferenceRequestDto dto, @MappingTarget ReferenceEntity entity);
}