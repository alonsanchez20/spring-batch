package com.training.springbatch.model.transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class TransactionOutput {


    @Id
    private Long id;
    private LocalDateTime timestamp;
    private String type;
    private BigDecimal amount;
    private Boolean reviewed;

    public TransactionOutput(Long id, LocalDateTime timestamp, String type, BigDecimal amount, Boolean reviewed) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.amount = amount;
        this.reviewed = reviewed;
    }

    public TransactionOutput() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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

    public Boolean getReviewed() {
        return reviewed;
    }

    public void setReviewed(Boolean reviewed) {
        this.reviewed = reviewed;
    }
}


