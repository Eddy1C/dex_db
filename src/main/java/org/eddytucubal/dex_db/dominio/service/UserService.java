package org.eddytucubal.dex_db.dominio.service;

import org.eddytucubal.dex_db.api.mapper.UserMapper;
import org.eddytucubal.dex_db.dominio.dto.UserRequestDto;
import org.eddytucubal.dex_db.dominio.dto.UserResponseDto;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<UserResponseDto> obtenerTodo() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public UserResponseDto obtenerPorId(Long id) {
        UserEntity userEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return mapper.toResponse(userEntity);
    }

    public UserResponseDto guardar(UserRequestDto dto) {
        UserEntity entity = mapper.toEntity(dto);
        UserEntity saved = repository.save(entity);
        return mapper.toResponse(saved);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
