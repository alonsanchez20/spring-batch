package com.training.springbatch.model.transaction;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TransactionInput {

    private Long id;
    private Timestamp timestamp;
    private String type;
    private Double amount;

}
