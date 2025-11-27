package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDto(
        @NotBlank(message = "El nombre de la categoria debe ser obligatorio")
        String nombre_categoria,
        @NotBlank(message = "La descripcion debe ser obligaotrio")
        String descripcion_categoria,
        @NotBlank(message = "El tipo debe de ser obligatorio")
        String tipo_categoria,
        @NotBlank(message = "El usuario asociado es obligatorio")
        Long id_user
) {
}
