package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record ReferenceResponseDto(
        @NotBlank(message = "EL codigo de la referencia no puede ser NULL")
        Long id_url,
        @NotBlank(message = "la url de la referencia debe ser obligatoria")
        String url,
        @NotBlank(message = "La fecha de guardado debe estar registrada")
        String fecha_url,
        @NotBlank(message = "El tipo de busqueda se debe registrar")
        String tipo_busqueda_url,
        @NotBlank(message = "El tipo de fuente es obligatorio")
        String tipo_fuente_url,
        @NotBlank(message = "El resumen se debe poder registrar")
        String resumen_url,
        @NotBlank(message = "la fecha de creado es obligatorio")
        String fecha_creado_url,
        @NotBlank(message = "La fecha que se actualiza debe ser guardada")
        String fecha_actualizado_url,
        @NotBlank(message = "El usuario asociado no puede ser NULL")
        Long id_user
) {
}
