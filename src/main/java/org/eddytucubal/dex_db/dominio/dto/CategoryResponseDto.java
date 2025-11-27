package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryResponseDto(
        @NotBlank(message = "El codigo no puede ser NULL")
        Long id_category,
        @NotBlank(message = "El nombre de la categoria no puede ser NULL")
        String nombre_categoria,
        @NotBlank(message = "La descripcion no puede ser NULL")
        String descripcion_categoria,
        @NotBlank(message = "El tipo debe no puede ser NULL")
        String tipo_categoria,
        @NotBlank(message = "El usuario asociado es obligatorio")
        Long id_user
) {
}
