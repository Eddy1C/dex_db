package org.eddytucubal.dex_db.dominio.service;

import org.eddytucubal.dex_db.api.mapper.AccountMapper;
import org.eddytucubal.dex_db.api.mapper.UserMapper;
import org.eddytucubal.dex_db.dominio.dto.AccountResponseDto;
import org.eddytucubal.dex_db.dominio.dto.UserRequestDto;
import org.eddytucubal.dex_db.dominio.dto.UserResponseDto;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AccountMapper accountMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper, AccountMapper accountMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.accountMapper = accountMapper;
    }

    public List<UserResponseDto> obtenerTodo() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    public UserResponseDto obtenerPorId(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
        return userMapper.toResponse(userEntity);
    }

    public UserResponseDto guardar(UserRequestDto dto) {
        UserEntity entity = userMapper.toEntity(dto);
        UserEntity saved = userRepository.save(entity);
        return userMapper.toResponse(saved);
    }

    public void eliminar(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDto actualizar(Long id, UserRequestDto dto) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));

        // MapStruct actualiza el entity
        userMapper.updateEntityFromDto(dto, userEntity);

        UserEntity updated = userRepository.save(userEntity);
        return userMapper.toResponse(updated);
    }

    public List<AccountResponseDto> obtenerAccountsDeUsuario(Long idUser) {
        UserEntity user = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return user.getAccounts()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }
}
