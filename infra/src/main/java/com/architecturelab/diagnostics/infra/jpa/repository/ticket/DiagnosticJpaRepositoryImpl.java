package com.architecturelab.diagnostics.infra.jpa.repository.ticket;

import com.architecturelab.diagnostics.infra.jpa.dao.DiagnosticDao;
import com.architecturelab.diagnostics.infra.jpa.dao.DiagnosticDao;
import com.architecturelab.diagnostics.infra.jpa.domain.Diagnostic;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@EnableJpaRepositories(basePackages = {"com.architecturelab.diagnostics"})
@EntityScan("com.architecturelab.diagnostics")
public class DiagnosticJpaRepositoryImpl implements DiagnosticJpaRepository {

    @Autowired
    private DiagnosticDao diagnosticDao;

    @Override
    public Diagnostic save(Diagnostic entity) {
        return diagnosticDao.save(entity);
    }

    @Override
    public Iterable<Diagnostic> getAll() {
        return diagnosticDao.findAll();
    }

    @Override
    public Optional<Diagnostic> getById(Long id) {
        return diagnosticDao.findById(id);
    }
}
