package com.jltorocode.companycrud.service;

import com.jltorocode.companycrud.dto.CompanyDto;
import com.jltorocode.companycrud.entity.Company;
import com.jltorocode.companycrud.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository repository;

    public List<CompanyDto> findAll() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public CompanyDto findById(Long id) {
        Company c = repository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
        return toDto(c);
    }

    public CompanyDto save(CompanyDto dto) {
        Company saved = repository.save(toEntity(dto));
        return toDto(saved);
    }

    public CompanyDto update(Long id, CompanyDto dto) {
        Company company = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        company.setName(dto.getName());
        company.setIndustry(dto.getIndustry());
        company.setCountry(dto.getCountry());
        return toDto(repository.save(company));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CompanyDto toDto(Company c) {
        return CompanyDto.builder()
                .id(c.getId())
                .name(c.getName())
                .industry(c.getIndustry())
                .country(c.getCountry())
                .build();
    }

    private Company toEntity(CompanyDto dto) {
        return Company.builder()
                .name(dto.getName())
                .industry(dto.getIndustry())
                .country(dto.getCountry())
                .build();
    }
}