package com.training.springbatch.service;

import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;

public interface TransactionValidator {

    TransactionOutput validateTransaction(TransactionInput item);
}
