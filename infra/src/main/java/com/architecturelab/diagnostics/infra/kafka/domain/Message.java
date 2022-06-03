package com.architecturelab.diagnostics.infra.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Message {

    private Long ticketId;
    private Long diagnosticId;
    private Date diagnosticDate;

}
