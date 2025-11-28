package org.eddytucubal.dex_db.dominio.service;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.CategoryMapper;
import org.eddytucubal.dex_db.dominio.dto.CategoryRequestDto;
import org.eddytucubal.dex_db.dominio.dto.CategoryResponseDto;
import org.eddytucubal.dex_db.dominio.repository.CategoryRepository;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CategoryMapper categoryMapper;

    // Crear categoría
    public CategoryResponseDto crear(CategoryRequestDto dto) {

        CategoryEntity categoryEntity = categoryMapper.toEntity(dto);

        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        categoryEntity.setUser(userEntity);

        categoryEntity = categoryRepository.save(categoryEntity);

        return categoryMapper.toResponse(categoryEntity);
    }

    // Obtener todas las categorías
    public List<CategoryResponseDto> obtenerTodo() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    // Obtener por ID
    public CategoryResponseDto obtenerPorId(Long id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        return categoryMapper.toResponse(category);
    }

    // Actualizar
    public CategoryResponseDto actualizar(Long id, CategoryRequestDto dto) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Actualiza campos simples (MapStruct)
        categoryMapper.updateFromDto(dto, category);

        // Actualizar user si viene en el DTO
        if (dto.id_user() != null) {
            UserEntity user = userRepository.findById(dto.id_user())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            category.setUser(user);
        }

        category = categoryRepository.save(category);

        return categoryMapper.toResponse(category);
    }

    // Eliminar
    public void eliminar(Long id) {
        categoryRepository.deleteById(id);
    }
}
