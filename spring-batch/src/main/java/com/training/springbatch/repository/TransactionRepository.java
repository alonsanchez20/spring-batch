package com.training.springbatch.repository;

import com.training.springbatch.model.transaction.TransactionOutput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionOutput, Long> {
}
