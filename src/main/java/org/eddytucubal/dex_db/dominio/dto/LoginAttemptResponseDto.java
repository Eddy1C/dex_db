package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginAttemptResponseDto(
        @NotBlank(message = "El codigo no puede ser NULL")
        Long id_attempt,
        @NotBlank(message = "La fecha y hora no puede ser NULL")
        String fecha_hora_intento_logueo,
        @NotBlank(message = "El resultado del logger no puede ser NULL")
        String exitoso_logueo,
        @NotBlank(message = "La razon debe estar registrada")
        String razon_logueo,
        @NotBlank(message = "la direccion ip es obligatoria")
        String direccion_ip_logueo,
        @NotBlank(message = "El agente de usuario no puede ser Null")
        String agente_usuario,
        @NotBlank(message = "El usuario asociado nopuede ser NULL")
        Long id_user
) {
}
