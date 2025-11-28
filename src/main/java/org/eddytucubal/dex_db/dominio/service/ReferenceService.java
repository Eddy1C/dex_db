package org.eddytucubal.dex_db.dominio.service;

import lombok.AllArgsConstructor;
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

    public ReferenceResponseDto crear(ReferenceRequestDto dto) {

        // 1. Convertimos lo básico
        ReferenceEntity referenceEntity = referenceMapper.toEntityReference(dto);

        // 2. Buscamos las relaciones
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Seteamos las relaciones
        referenceEntity.setUser(userEntity);

        // 4. Guardamos
        referenceEntity = referenceRepository.save(referenceEntity);

        // 5. Retornamos como ResponseDto
        return referenceMapper.toResponseDto(referenceEntity);
    }

    public List<ReferenceResponseDto> obtenerTodo() {
        return referenceRepository.findAll()
                .stream()
                .map(referenceMapper::toResponseDto)
                .toList();
    }
}
