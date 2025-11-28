package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.CategoryRequestDto;
import org.eddytucubal.dex_db.dominio.dto.CategoryResponseDto;
import org.eddytucubal.dex_db.dominio.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // CREATE
    @PostMapping
    public CategoryResponseDto crear(@RequestBody CategoryRequestDto dto) {
        return categoryService.crear(dto);
    }

    // GET ALL
    @GetMapping
    public List<CategoryResponseDto> obtenerTodo() {
        return categoryService.obtenerTodo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public CategoryResponseDto obtenerPorId(@PathVariable Long id) {
        return categoryService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public CategoryResponseDto actualizar(@PathVariable Long id, @RequestBody CategoryRequestDto dto) {
        return categoryService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        categoryService.eliminar(id);
    }
}