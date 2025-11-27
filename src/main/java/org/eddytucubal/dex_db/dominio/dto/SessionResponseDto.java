package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record SessionResponseDto(
        @NotBlank(message = "El codigo de la sesion no puede ser NULL")
        Long id_session,
        @NotBlank(message = "El dispositivo de inicio de sesion es obligatorio")
        String dispositivo_sesion,
        @NotBlank(message = "Sistema operativo obligatorio")
        String sistema_operativo_sesion,
        @NotBlank(message = "La ip del dispositivo es obligatorio")
        String ip_dispositivo_sesion,
        @NotBlank(message = "El tokem de la sesion es obligatorio")
        String tokem_sesion,
        @NotBlank(message = "Estado de la sesion obligatorio")
        String sesion_activa,
        @NotBlank(message = "La fecha y hora de inicio debe guardarse")
        String fecha_hora_inicio_sesion,
        @NotBlank(message = "La fecha y hora de cierre debe guardarse")
        String fecha_hora_cierre_sesion,
        @NotBlank(message = "fecha de expiracion automatica de la sesion obligatoria")
        String fecha_expiracion_sesion,
        @NotBlank(message = "Inico de sesion en plataforma requerido")
        String plataforma_sesion,
        @NotBlank(message = "Codigo de usuario asociado requerido")
        Long id_user
) {
}
