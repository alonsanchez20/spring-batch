package com.training.springbatch.model.transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Builder
@Entity
@Data
public class TransactionOutput {

    @Id
    private Long id;
    private Timestamp timestamp;
    private String type;
    private Double amount;
    private Boolean reviewed;

    public TransactionOutput() {

    }
}


