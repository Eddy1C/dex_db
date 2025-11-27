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

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final AccountMapper accountMapper;

    public AccountResponseDto crear(AccountRequestDto dto) {

        // 1. Convertimos lo básico
        AccountEntity accountEntity = accountMapper.toEntity(dto);

        // 2. Buscamos las relaciones
        UserEntity userEntity = userRepository.findById(dto.id_user())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        CategoryEntity categoryEntity = categoryRepository.findById(dto.id())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        // 3. Seteamos las relaciones
        account.setUser(user);
        account.setCategory(category);

        // 4. Guardamos
        account = accountRepository.save(account);

        // 5. Retornamos como ResponseDto
        return accountMapper.toResponse(account);
    }

    public List<AccountResponseDto> obtenerTodo() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toResponse)
                .toList();
    }
}
