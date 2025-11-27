package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.NotBlank;

public record MotionResponseDto(
        @NotBlank(message = "Codigo de movimiento no puede ser NULL")
        Long id_movement,
        @NotBlank(message = "la fecha y hora del movimineto debe estar registrada")
        String fecha_hora_movimiento,
        @NotBlank(message = "El monto del movimiento debe estar registrado")
        String monto_movimiento,
        @NotBlank(message = "El comercio es obligatorio")
        String comercio_movimiento,
        @NotBlank(message = "El tipo de movimiento es Obligatorio")
        String tipo_movimiento,
        @NotBlank(message = "Debe incluir una breve descripcion el movimiento")
        String descripcion_movimiento,
        @NotBlank(message = "Id de movimineto de api obligatorio")
        Long id_api_movimiento,
        @NotBlank(message = "Cuenta de origen obligatorio")
        Long id_account_origin,
        @NotBlank(message = "Cuneta de destino obligatorio")
        Long id_account_destination,
        @NotBlank(message = "Categoria asociada obligatoria")
        Long id_category
) {
}
