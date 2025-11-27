package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountResponseDto(
        @NotBlank(message = "El codigo asociado no puede ser NULL")
        Long id_account,
        @NotBlank(message = "El nombre de la cuenta es Obligatorio")
        String nombre_cuenta,
        @NotBlank(message = "El Saldo de la cuenta no puede estar vacio")
        double saldo_cuenta,
        String fecha_actualizacion_cuenta,
        @NotBlank(message = "El banco asociado a la cuenta no puede estar vacio")
        String banco_cuenta,
        @NotBlank(message = "El tipo es Obligatorio")
        String tipo_cuenta,
        @NotBlank(message = "El usuario asociado es obligatorio")
        Long id_user,
        @NotBlank(message = "La categoria no se encuentra")
        Long id_category
) {
}
