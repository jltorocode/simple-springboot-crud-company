package com.jltorocode.companycrud.repository;

import com.jltorocode.companycrud.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
