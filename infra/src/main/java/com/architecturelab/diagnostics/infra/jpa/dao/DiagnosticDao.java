package com.architecturelab.diagnostics.infra.jpa.dao;

import com.architecturelab.diagnostics.infra.jpa.domain.Diagnostic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiagnosticDao extends CrudRepository<Diagnostic, Long> {

    Optional<Diagnostic> findByTicketId(Long ticketId);
}
