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

    // --------------------------------------------------------
    // CREAR
    // --------------------------------------------------------
    public SessionResponseDto crear(SessionRequestDto dto) {
        SessionEntity sessionEntity = sessionMapper.toSessionEntity(dto);

        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        sessionEntity.setUser(userEntity);

        sessionEntity = sessionRepository.save(sessionEntity);
        return sessionMapper.toResponseDto(sessionEntity);
    }

    // --------------------------------------------------------
    // LISTAR TODO
    // --------------------------------------------------------
    public List<SessionResponseDto> obtenerTodo() {
        return sessionRepository.findAll()
                .stream()
                .map(sessionMapper::toResponseDto)
                .toList();
    }

    // --------------------------------------------------------
    // OBTENER POR ID
    // --------------------------------------------------------
    public SessionResponseDto obtenerPorId(Long id) {
        SessionEntity entity = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return sessionMapper.toResponseDto(entity);
    }

    // --------------------------------------------------------
    // ACTUALIZAR (PUT)
    // --------------------------------------------------------
    public SessionResponseDto actualizar(Long id, SessionRequestDto dto) {

        // 1. Obtener la cuenta existente
        SessionEntity sessionEntity = sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // 2. Actualizar campos normales
        sessionMapper.updateEntityFromDto(dto, sessionEntity);

        // 3. Actualizar relaciones (igual que en crear)
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        sessionEntity.setUser(userEntity);

        // 4. Guardar cambios
        SessionEntity actualizado = sessionRepository.save(sessionEntity);

        // 5. Retornar response
        return sessionMapper.toResponseDto(actualizado);
    }

    // --------------------------------------------------------
    // ELIMINAR
    // --------------------------------------------------------
    public void eliminar(Long id) {
        if (!sessionRepository.existsById(id)) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        sessionRepository.deleteById(id);
    }
}