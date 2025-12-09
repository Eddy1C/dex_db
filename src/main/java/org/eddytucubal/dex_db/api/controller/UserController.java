package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.UserRequestDto;
import org.eddytucubal.dex_db.dominio.dto.UserResponseDto;
import org.eddytucubal.dex_db.dominio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // CREATE
    @PostMapping
    public ResponseEntity<UserResponseDto> crearUsuario(@RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(userService.guardar(dto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> obtenerUsuarios() {
        return ResponseEntity.ok(userService.obtenerTodo());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> obtenerUsuario(@PathVariable Long id) {
        return ResponseEntity.ok(userService.obtenerPorId(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> actualizarUsuario(
            @PathVariable Long id,
            @RequestBody UserRequestDto dto
    ) {
        return ResponseEntity.ok(userService.actualizar(id, dto));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        userService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-email/{email}")
    public ResponseEntity<UserResponseDto> obtenerPorEmail(@PathVariable String emailUser) {
        return ResponseEntity.ok(userService.obtenerPorEmail(emailUser));
    }

}