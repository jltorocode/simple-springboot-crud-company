package com.jltorocode.companycrud.controller;

import com.jltorocode.companycrud.dto.CompanyDto;
import com.jltorocode.companycrud.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
@Tag(name = "Companies", description = "CRUD de empresas")
public class CompanyController {

    private final CompanyService service;

    @GetMapping
    @Operation(summary = "Listar compañías")
    public List<CompanyDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener compañía por ID")
    public CompanyDto getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Crear compañía")
    public CompanyDto create(@RequestBody CompanyDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar compañía")
    public CompanyDto update(@PathVariable Long id, @RequestBody CompanyDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar compañía")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}