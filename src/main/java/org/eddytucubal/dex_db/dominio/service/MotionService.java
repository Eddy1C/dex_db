package org.eddytucubal.dex_db.dominio.service;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.MotionMapper;
import org.eddytucubal.dex_db.dominio.dto.MotionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.MotionResponseDto;
import org.eddytucubal.dex_db.dominio.repository.CategoryRepository;
import org.eddytucubal.dex_db.dominio.repository.MotionRepository;
import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.eddytucubal.dex_db.persistence.entity.MotionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotionService {
    private final MotionRepository motionRepository;
    private final CategoryRepository categoryRepository;
    private final MotionMapper motionMapper;

    // --------------------------------------------------------
    // CREAR
    // --------------------------------------------------------
    public MotionResponseDto crear(MotionRequestDto dto) {
        MotionEntity motionEntity = motionMapper.toEntity(dto);

        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        motionEntity.setCategory(categoryEntity);

        motionEntity = motionRepository.save(motionEntity);
        return motionMapper.toResponse(motionEntity);
    }

    // --------------------------------------------------------
    // LISTAR TODO
    // --------------------------------------------------------
    public List<MotionResponseDto> obtenerTodo() {
        return motionRepository.findAll()
                .stream()
                .map(motionMapper::toResponse)
                .toList();
    }

    // --------------------------------------------------------
    // OBTENER POR ID
    // --------------------------------------------------------
    public MotionResponseDto obtenerPorId(Long id) {
        MotionEntity entity = motionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return motionMapper.toResponse(entity);
    }

    // --------------------------------------------------------
    // ACTUALIZAR (PUT)
    // --------------------------------------------------------
    public MotionResponseDto actualizar(Long id, MotionResponseDto dto) {

        // 1. Obtener la cuenta existente
        MotionEntity accountEntity = motionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // 2. Actualizar campos normales
        motionMapper.updateEntityFromDto(dto, accountEntity);

        // 3. Actualizar relaciones (igual que en crear)
        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        accountEntity.setCategory(categoryEntity);

        // 4. Guardar cambios
        MotionEntity actualizado = motionRepository.save(accountEntity);

        // 5. Retornar response
        return motionMapper.toResponse(actualizado);
    }

    // --------------------------------------------------------
    // ELIMINAR
    // --------------------------------------------------------
    public void eliminar(Long id) {
        if (!motionRepository.existsById(id)) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        motionRepository.deleteById(id);
    }
}