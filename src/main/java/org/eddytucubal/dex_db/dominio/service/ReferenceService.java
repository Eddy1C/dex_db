package org.eddytucubal.dex_db.dominio.service;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.ReferenceMapper;
import org.eddytucubal.dex_db.dominio.dto.ReferenceRequestDto;
import org.eddytucubal.dex_db.dominio.dto.ReferenceResponseDto;
import org.eddytucubal.dex_db.dominio.repository.ReferenceRepository;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.ReferenceEntity;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceService {

    private final ReferenceRepository referenceRepository;
    private final UserRepository userRepository;
    private final ReferenceMapper referenceMapper;

    // --------------------------------------------------------
    // CREAR
    // --------------------------------------------------------
    public ReferenceResponseDto crear(ReferenceRequestDto dto) {
        ReferenceEntity referenceEntity = referenceMapper.toEntityReference(dto);

        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        referenceEntity.setUser(userEntity);

        referenceEntity = referenceRepository.save(referenceEntity);
        return referenceMapper.toResponseDto(referenceEntity);
    }

    // --------------------------------------------------------
    // LISTAR TODO
    // --------------------------------------------------------
    public List<ReferenceResponseDto> obtenerTodo() {
        return referenceRepository.findAll()
                .stream()
                .map(referenceMapper::toResponseDto)
                .toList();
    }

    // --------------------------------------------------------
    // OBTENER POR ID
    // --------------------------------------------------------
    public ReferenceResponseDto obtenerPorId(Long id) {
        ReferenceEntity referenceEntity = referenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return referenceMapper.toResponseDto(referenceEntity);
    }

    // --------------------------------------------------------
    // ACTUALIZAR (PUT)
    // --------------------------------------------------------
    public ReferenceResponseDto actualizar(Long id, ReferenceRequestDto dto) {

        // 1. Obtener la cuenta existente
        ReferenceEntity referenceEntity = referenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // 2. Actualizar campos normales
        referenceMapper.updateEntityFromDto(dto, referenceEntity);

        // 3. Actualizar relaciones (igual que en crear)
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        referenceEntity.setUser(userEntity);

        // 4. Guardar cambios
        ReferenceEntity actualizado = referenceRepository.save(referenceEntity);

        // 5. Retornar response
        return referenceMapper.toResponseDto(actualizado);
    }

    // --------------------------------------------------------
    // ELIMINAR
    // --------------------------------------------------------
    public void eliminar(Long id) {
        if (!referenceRepository.existsById(id)) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        referenceRepository.deleteById(id);
    }
}