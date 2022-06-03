package com.architecturelab.diagnostics.application.controller;

import com.architecturelab.diagnostics.core.domain.diagnostic.DiagnosticInput;
import com.architecturelab.diagnostics.useCases.diagnostic.DiagnosticInputUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnostics")
public class DiagnosticsController {

    @Autowired
    private DiagnosticInputUseCases diagnosticInputUseCases;

    @GetMapping("/diagnostic/{id}")
    public ResponseEntity<DiagnosticInput> getDiagnosticById(@PathVariable Long id) {
        try {
            DiagnosticInput diagnosticInput = diagnosticInputUseCases.getById(id);
            if (diagnosticInput != null) {
                return new ResponseEntity<>(diagnosticInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diagnostic/ticket/{ticketId}")
    public ResponseEntity<DiagnosticInput> getDiagnosticByTicketId(@PathVariable Long ticketId) {
        try {
            DiagnosticInput diagnosticInput = diagnosticInputUseCases.getByTicketId(ticketId);
            if (diagnosticInput != null) {
                return new ResponseEntity<>(diagnosticInput, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/diagnostic")
    public ResponseEntity<DiagnosticInput> createDiagnostic(@RequestBody DiagnosticInput diagnosticInput) {
        try {
            DiagnosticInput _diagnosticInput = diagnosticInputUseCases.create(diagnosticInput);
            return new ResponseEntity<>(_diagnosticInput, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/diagnostic")
    public ResponseEntity<DiagnosticInput> updateDiagnostic(@RequestBody DiagnosticInput diagnosticInput) {
        try {
            DiagnosticInput _diagnosticInput = diagnosticInputUseCases.update(diagnosticInput);
            if (_diagnosticInput !=null) {
                return new ResponseEntity<>(_diagnosticInput, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/diagnostics")
    public ResponseEntity<List<DiagnosticInput>> getAllDiagnostics() {
        try {
            List<DiagnosticInput> diagnosticInputs = diagnosticInputUseCases.getAll();
            if (diagnosticInputs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(diagnosticInputs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/kafka")
    public String sendMessage() {
        diagnosticInputUseCases.sendMessage();
        return "sent";
    }
}
