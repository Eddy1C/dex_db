package org.eddytucubal.dex_db.dominio.service;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.api.mapper.AccountMapper;
import org.eddytucubal.dex_db.dominio.dto.AccountRequestDto;
import org.eddytucubal.dex_db.dominio.dto.AccountResponseDto;
import org.eddytucubal.dex_db.dominio.repository.AccountRepository;
import org.eddytucubal.dex_db.dominio.repository.CategoryRepository;
import org.eddytucubal.dex_db.dominio.repository.UserRepository;
import org.eddytucubal.dex_db.persistence.entity.AccountEntity;
import org.eddytucubal.dex_db.persistence.entity.CategoryEntity;
import org.eddytucubal.dex_db.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AccountMapper accountMapper;

    // --------------------------------------------------------
    // CREAR
    // --------------------------------------------------------
    public AccountResponseDto crear(AccountRequestDto dto) {
        AccountEntity accountEntity = accountMapper.toEntity(dto);

        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        accountEntity.setUser(userEntity);
        accountEntity.setCategory(categoryEntity);

        accountEntity = accountRepository.save(accountEntity);
        return accountMapper.toResponse(accountEntity);
    }

    // --------------------------------------------------------
    // LISTAR TODO
    // --------------------------------------------------------
    public List<AccountResponseDto> obtenerTodo() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }

    // --------------------------------------------------------
    // OBTENER POR ID
    // --------------------------------------------------------
    public AccountResponseDto obtenerPorId(Long id) {
        AccountEntity entity = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        return accountMapper.toResponse(entity);
    }

    // --------------------------------------------------------
    // ACTUALIZAR (PUT)
    // --------------------------------------------------------
    public AccountResponseDto actualizar(Long id, AccountRequestDto dto) {

        // 1. Obtener la cuenta existente
        AccountEntity accountEntity = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

        // 2. Actualizar campos normales
        accountMapper.updateEntityFromDto(dto, accountEntity);

        // 3. Actualizar relaciones (igual que en crear)
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoryEntity categoryEntity = categoryRepository.findById(dto.id_category())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        accountEntity.setUser(userEntity);
        accountEntity.setCategory(categoryEntity);

        // 4. Guardar cambios
        AccountEntity actualizado = accountRepository.save(accountEntity);

        // 5. Retornar response
        return accountMapper.toResponse(actualizado);
    }

    // --------------------------------------------------------
    // ELIMINAR
    // --------------------------------------------------------
    public void eliminar(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new RuntimeException("Cuenta no encontrada");
        }
        accountRepository.deleteById(id);
    }
}