package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.SessionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.SessionResponseDto;
import org.eddytucubal.dex_db.dominio.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    // CREATE
    @PostMapping
    public SessionResponseDto crear(@RequestBody SessionRequestDto dto) {
        return sessionService.crear(dto);
    }

    // GET ALL
    @GetMapping
    public List<SessionResponseDto> obtenerTodo() {
        return sessionService.obtenerTodo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public SessionResponseDto obtenerPorId(@PathVariable Long id) {
        return sessionService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public SessionResponseDto actualizar(@PathVariable Long id, @RequestBody SessionRequestDto dto) {
        return sessionService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        sessionService.eliminar(id);
    }
}
