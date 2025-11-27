package org.eddytucubal.dex_db.dominio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,
        @NotBlank(message = "El apellido es obligatorio")
        String apellido,
        @Email(message = "El correo debe ser válido")
        @NotBlank(message = "El correo es obligatorio")
        String correo,
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String contrasenia,
        @NotBlank(message = "La fecha de creacion es obligatoria")
        String fecha_creacion,
        @NotBlank(message = "La fecha de nacimiento es obligatorio")
        String fecha_nacimiento,
        @NotBlank(message = "Genero de usuario obligatorio")
        String genero_usuario
) {
}
