package com.training.springbatch.model.transaction;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class TransactionInput {

    public TransactionInput(Long id, String timestamp, String type, BigDecimal amount) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
    }

    public TransactionInput() {
    }

    private Long id;
    private String timestamp;
    private String type;
    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

