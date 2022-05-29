package com.architecturelab.diagnostics.infra.jpa.repository.ticket;

import com.architecturelab.diagnostics.infra.jpa.domain.Diagnostic;

import java.util.Optional;

public interface DiagnosticJpaRepository {

    public Diagnostic save(Diagnostic entity);

    public Iterable<Diagnostic> getAll();

    public Optional<Diagnostic> getById(Long id);

}
