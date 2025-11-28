package org.eddytucubal.dex_db.api.controller;

import lombok.RequiredArgsConstructor;
import org.eddytucubal.dex_db.dominio.dto.AccountRequestDto;
import org.eddytucubal.dex_db.dominio.dto.AccountResponseDto;
import org.eddytucubal.dex_db.dominio.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // CREATE
    @PostMapping
    public AccountResponseDto crear(@RequestBody AccountRequestDto dto) {
        return accountService.crear(dto);
    }

    // GET ALL
    @GetMapping
    public List<AccountResponseDto> obtenerTodo() {
        return accountService.obtenerTodo();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public AccountResponseDto obtenerPorId(@PathVariable Long id) {
        return accountService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public AccountResponseDto actualizar(@PathVariable Long id, @RequestBody AccountRequestDto dto) {
        return accountService.actualizar(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        accountService.eliminar(id);
    }
}