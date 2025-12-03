package org.eddytucubal.dex_db.dominio.service;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.MotionMapper;
import org.eddytucubal.dex_db.dominio.dto.MotionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.MotionResponseDto;
import org.eddytucubal.dex_db.dominio.repository.AccountRepository;
import org.eddytucubal.dex_db.dominio.repository.CategoryRepository;
import org.eddytucubal.dex_db.dominio.repository.MotionRepository;
import org.eddytucubal.dex_db.persistence.entity.AccountEntity;
import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.eddytucubal.dex_db.persistence.entity.MotionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MotionService {
    private final MotionRepository motionRepository;
    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;
    private final MotionMapper motionMapper;

    // --------------------------------------------------------
    // CREAR
    // --------------------------------------------------------
    public MotionResponseDto crear(MotionRequestDto dto) {

        // Convertimos el DTO a entidad
        MotionEntity motionEntity = motionMapper.toEntity(dto);

        // Buscar categoría
        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // Buscar cuenta origen
        AccountEntity accountEntityOrigin = accountRepository.findById(dto.id_account_origin())
                .orElseThrow(() -> new RuntimeException("Cuenta de origen no encontrada"));

        // Buscar cuenta destino
        AccountEntity accountEntityDestination = accountRepository.findById(dto.id_account_destination())
                .orElseThrow(() -> new RuntimeException("Cuenta de destino no encontrada"));

        // Asignar relaciones
        motionEntity.setCategory(categoryEntity);
        motionEntity.setAccountOrigin(accountEntityOrigin);
        motionEntity.setAccountDestination(accountEntityDestination);

        // Guardar el movimiento
        motionEntity = motionRepository.save(motionEntity);

        // Retornar la respuesta
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
        MotionEntity motionEntity = motionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
        return motionMapper.toResponse(motionEntity);
    }

    // --------------------------------------------------------
    // ACTUALIZAR (PUT)
    // --------------------------------------------------------
    public MotionResponseDto actualizar(Long id, MotionRequestDto dto) {

        // 1. Obtener la cuenta existente
        MotionEntity motionEntity = motionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

        // 2. Actualizar campos normales
        motionMapper.updateEntityFromDto(dto, motionEntity);

        // 3. Actualizar relaciones (igual que en crear)
        AccountEntity accountEntity = accountRepository.findById(dto.id_account())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        motionEntity.setAccount(accountEntity);
        motionEntity.setCategory(categoryEntity);

        // 4. Guardar cambios
        MotionEntity actualizado = motionRepository.save(motionEntity);

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