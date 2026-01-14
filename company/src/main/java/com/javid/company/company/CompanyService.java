package com.javid.company.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company registerCompany(Company company);
    Company updateCompany(Long id,Company company);
}
