package com.architecturelab.diagnostics.useCases.diagnostic;

import com.architecturelab.diagnostics.core.domain.diagnostic.DiagnosticInput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiagnosticInputUseCases {

    public DiagnosticInput create(DiagnosticInput diagnosticInput);

    public DiagnosticInput update(DiagnosticInput diagnosticInput);

    public List<DiagnosticInput> getAll();

    public DiagnosticInput getById(Long id);

    public void sendMessage();

}
