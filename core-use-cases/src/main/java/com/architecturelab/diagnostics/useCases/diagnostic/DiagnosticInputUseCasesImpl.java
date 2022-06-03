package com.architecturelab.diagnostics.useCases.diagnostic;

import com.architecturelab.diagnostics.core.domain.diagnostic.DiagnosticInput;
import com.architecturelab.diagnostics.infra.jpa.domain.Diagnostic;
import com.architecturelab.diagnostics.infra.jpa.repository.ticket.DiagnosticJpaRepository;
import com.architecturelab.diagnostics.infra.kafka.producer.KafkaProducerServiceImpl;
import com.architecturelab.diagnostics.infra.kafka.domain.Message;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DiagnosticInputUseCasesImpl implements DiagnosticInputUseCases {

    private static final Logger LOG = LoggerFactory.getLogger(DiagnosticInputUseCasesImpl.class);

    @Autowired
    private DiagnosticJpaRepository diagnosticJpaRepository;

    @Autowired
    private KafkaProducerServiceImpl kafkaProducerServiceImpl;

    @Override
    public DiagnosticInput create(DiagnosticInput diagnosticInput) {
        LOG.trace("Creating diagnostic");
        Diagnostic diagnostic = diagnosticJpaRepository.save(new Diagnostic(
                diagnosticInput.getDiagnosticId(),
                diagnosticInput.getTicketId(),
                diagnosticInput.getDescripcion(),
                diagnosticInput.getApto(),
                diagnosticInput.getReparacion(),
                diagnosticInput.getUsuarioCreacion(),
                diagnosticInput.getFechaCreacion(),
                diagnosticInput.getUsuarioModifica(),
                diagnosticInput.getFechaModifica()
        ));
        DiagnosticInput input = new DiagnosticInput(
                diagnostic.getId(),
                diagnostic.getTicketId(),
                diagnostic.getDescripcion(),
                diagnostic.getApto(),
                diagnostic.getReparacion(),
                diagnostic.getUsuarioCreacion(),
                diagnostic.getFechaCreacion(),
                diagnostic.getUsuarioModifica(),
                diagnostic.getFechaModifica()
        );
        return input;
    }

    @Override
    public DiagnosticInput update(DiagnosticInput diagnosticInput) {
        LOG.trace("Updating diagnostic");
        Optional<Diagnostic> diagnosticData = diagnosticJpaRepository.getById(diagnosticInput.getDiagnosticId());
        if (diagnosticData.isPresent()){
            Diagnostic diagnostic = diagnosticData.get();
            diagnostic.setTicketId(diagnosticInput.getTicketId());
            diagnostic.setDescripcion(diagnosticInput.getDescripcion());
            diagnostic.setApto(diagnosticInput.getApto());
            diagnostic.setReparacion(diagnosticInput.getReparacion());
            diagnostic.setUsuarioCreacion(diagnosticInput.getUsuarioCreacion());
            diagnostic.setFechaCreacion(diagnosticInput.getFechaCreacion());
            diagnostic.setUsuarioModifica(diagnosticInput.getUsuarioModifica());
            diagnostic.setFechaModifica(diagnosticInput.getFechaModifica());

            Diagnostic updated = diagnosticJpaRepository.save(diagnostic);
            DiagnosticInput input = new DiagnosticInput(
                    updated.getId(),
                    updated.getTicketId(),
                    updated.getDescripcion(),
                    updated.getApto(),
                    updated.getReparacion(),
                    updated.getUsuarioCreacion(),
                    updated.getFechaCreacion(),
                    updated.getUsuarioModifica(),
                    updated.getFechaModifica()
            );
            return input;
        }
        return null;
    }

    @Override
    public List<DiagnosticInput> getAll() {
        LOG.trace("Getting all diagnostics");
        List<Diagnostic> diagnostics = (List<Diagnostic>) diagnosticJpaRepository.getAll();

        List<DiagnosticInput> inputs = new ArrayList<DiagnosticInput>();

        diagnostics.forEach(i -> {
            DiagnosticInput diagnostic = new DiagnosticInput(
                    i.getId(),
                    i.getTicketId(),
                    i.getDescripcion(),
                    i.getApto(),
                    i.getReparacion(),
                    i.getUsuarioCreacion(),
                    i.getFechaCreacion(),
                    i.getUsuarioModifica(),
                    i.getFechaModifica()
            );
            inputs.add(diagnostic);
        });
        return inputs;
    }

    @Override
    public DiagnosticInput getById(Long id) {
        LOG.trace("Getting diagnostic with id " + id);
        Optional<Diagnostic> diagnosticData = diagnosticJpaRepository.getById(id);
        if (diagnosticData.isPresent()){
            Diagnostic diagnostic = diagnosticData.get();
            DiagnosticInput input = new DiagnosticInput(
                    diagnostic.getId(),
                    diagnostic.getTicketId(),
                    diagnostic.getDescripcion(),
                    diagnostic.getApto(),
                    diagnostic.getReparacion(),
                    diagnostic.getUsuarioCreacion(),
                    diagnostic.getFechaCreacion(),
                    diagnostic.getUsuarioModifica(),
                    diagnostic.getFechaModifica()
            );
            return input;
        }
        return null;
    }

    @Override
    public DiagnosticInput getByTicketId(Long id) {
        Optional<Diagnostic> diagnosticData = diagnosticJpaRepository.getByTicketId(id);
        if (diagnosticData.isPresent()){
            Diagnostic diagnostic = diagnosticData.get();
            DiagnosticInput input = new DiagnosticInput(
                    diagnostic.getId(),
                    diagnostic.getTicketId(),
                    diagnostic.getDescripcion(),
                    diagnostic.getApto(),
                    diagnostic.getReparacion(),
                    diagnostic.getUsuarioCreacion(),
                    diagnostic.getFechaCreacion(),
                    diagnostic.getUsuarioModifica(),
                    diagnostic.getFechaModifica()
            );
            return input;
        }
        return null;
    }

    @Override
    public void sendMessage() {
        kafkaProducerServiceImpl.send(new Message(1L,1L, new Date()));
    }
}
