package com.architecturelab.diagnostics.core.domain.diagnostic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class DiagnosticInput {

    private Long diagnosticId;

    private Long ticketId;

    private String descripcion;

    private Boolean apto;

    private Boolean reparacion;

    private String usuarioCreacion;

    private Date fechaCreacion;

    private String usuarioModifica;

    private Date fechaModifica;
}
