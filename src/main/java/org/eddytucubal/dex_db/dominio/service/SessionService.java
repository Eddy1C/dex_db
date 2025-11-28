package org.eddytucubal.dex_db.dominio.service;


import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.SessionMapper;
import org.eddytucubal.dex_db.dominio.dto.SessionRequestDto;
import org.eddytucubal.dex_db.dominio.dto.SessionResponseDto;
import org.eddytucubal.dex_db.dominio.repository.SessionRepository;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.SessionEntity;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final SessionMapper sessionMapper;

    public SessionResponseDto crear(SessionRequestDto dto) {

        // 1. Convertimos lo básico
        SessionEntity sessionEntity = sessionMapper.toEntity(dto);

        // 2. Buscamos las relaciones
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3. Seteamos las relaciones
        sessionEntity.setUser(userEntity);

        // 4. Guardamos
        sessionEntity = sessionRepository.save(sessionEntity);

        // 5. Retornamos como ResponseDto
        return sessionMapper.toResponse(sessionEntity);
    }

    public List<SessionResponseDto> obtenerTodo() {
        return sessionRepository.findAll()
                .stream()
                .map(sessionMapper::toResponse)
                .toList();
    }
}