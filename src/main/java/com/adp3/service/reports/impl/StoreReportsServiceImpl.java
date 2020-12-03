package com.adp3.service.reports.impl;

import com.adp3.entity.reports.StoreReports;
import com.adp3.factory.reports.StoreReportFactory;
import com.adp3.repository.reports.StoreReportsRepository;
import com.adp3.service.reports.StoreReportsService;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class  StoreReportsServiceImpl implements StoreReportsService {

    @Autowired
    StoreReportsRepository repository;

    @Override
    public Set<StoreReports> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public StoreReports create(StoreReports storeReports) {
        return this.repository.save(storeReports);
    }

    @Override
    public StoreReports read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public StoreReports update(StoreReports storeReports) {
        if (this.repository.existsById(storeReports.getStoreReportID())){
            return this.repository.save(storeReports);
        }
        return null;

    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);

    }
}
