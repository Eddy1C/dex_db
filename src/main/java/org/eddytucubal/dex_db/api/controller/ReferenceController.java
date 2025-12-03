package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.ReferenceRequestDto;
import org.eddytucubal.dex_db.dominio.dto.ReferenceResponseDto;
import org.eddytucubal.dex_db.dominio.service.ReferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class ReferenceController {
    private final ReferenceService  referenceService;
    // CREATE
    @PostMapping
    public ReferenceResponseDto crear(@RequestBody ReferenceRequestDto dto) {
        return referenceService.crear(dto);
    }

    // GET ALL
    @GetMapping
    public List<ReferenceResponseDto> obtenerTodo() {
        return referenceService.obtenerTodo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ReferenceResponseDto obtenerPorId(@PathVariable Long id) {
        return referenceService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ReferenceResponseDto actualizar(@PathVariable Long id, @RequestBody ReferenceRequestDto dto ) {
        return referenceService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        referenceService.eliminar(id);
    }
}