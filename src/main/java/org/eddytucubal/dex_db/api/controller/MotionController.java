package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.MotionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.MotionResponseDto;
import org.eddytucubal.dex_db.dominio.service.MotionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
public class MotionController {
    private final MotionService motionService;

    // CREATE
    @PostMapping
    public MotionResponseDto crear(@RequestBody MotionRequestDto dto) {
        return motionService.crear(dto);
    }

    // GET ALL
    @GetMapping
    public List<MotionResponseDto> obtenerTodo() {
        return motionService.obtenerTodo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public MotionResponseDto obtenerPorId(@PathVariable Long id) {
        return motionService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public MotionResponseDto actualizar(@PathVariable Long id, @RequestBody MotionRequestDto dto ) {
        return motionService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        motionService.eliminar(id);
    }
}