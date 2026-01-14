package com.javid.company.company.impl;

import com.javid.company.company.Company;
import com.javid.company.company.CompanyRepository;
import com.javid.company.company.CompanyService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company registerCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Long id, Company company) {
        Company newcompany = companyRepository.findById(id)
                .orElseThrow();
        System.out.println("DEBUG: Company received: " + company.getName());
        newcompany.setDescription(company.getDescription());
        newcompany.setName(company.getName());
//        newcompany.setJobs(company.getJobs());
        return companyRepository.save(newcompany);
    }

}
