package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginAttemptRequestDto (
        @NotBlank(message = "La fecha y hora es obligatoria")
        String fecha_hora_intento_logueo,
        @NotBlank(message = "El resultado del logger es obligatorio")
        String exitoso_logueo,
        @NotBlank(message = "La razon debe estar registrada")
        String razon_logueo,
        @NotBlank(message = "la ip es obligatoria")
        String direccion_ip_logueo,
        @NotBlank(message = "El agente de usuario debe ser Obligatorio")
        String agente_usuario,
        @NotBlank(message = "El usuario asociado debe ser registrado")
        Long id_user
){
}
