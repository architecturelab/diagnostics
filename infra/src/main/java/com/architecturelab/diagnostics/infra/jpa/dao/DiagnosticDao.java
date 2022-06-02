package com.architecturelab.diagnostics.infra.jpa.dao;

import com.architecturelab.diagnostics.infra.jpa.domain.Diagnostic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticDao extends CrudRepository<Diagnostic, Long> {
}
