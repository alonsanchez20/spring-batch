package com.training.springbatch.service;

import com.training.springbatch.exceptions.InvalidAmountException;
import com.training.springbatch.mapper.DataFormatMapperInterface;
import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;
import com.training.springbatch.processor.TransactionProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionValidatorImpl implements TransactionValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionValidatorImpl.class);

    @Autowired
    private DataFormatMapperInterface dataFormatMapperInterface;

    @Override
    public TransactionOutput validateTransaction(TransactionInput item) {


        if (!validateAmount(item.getAmount())) {
            throw new InvalidAmountException("Amount cant be higher than 1000");
        }


        return generateReturnTransactionObject(item);

    }

    private Boolean validateAmount(BigDecimal amount) {
        return 1000 >= amount.intValue();
    }

    private TransactionOutput generateReturnTransactionObject(TransactionInput item) {

        TransactionOutput transactionOutput = new TransactionOutput();
        transactionOutput.setId(item.getId());
        transactionOutput.setType(item.getType());
        transactionOutput.setAmount(item.getAmount());
        transactionOutput.setTimestamp(dataFormatMapperInterface.dateString2LocalDateTime(item.getTimestamp()));
        transactionOutput.setReviewed(true);

        return transactionOutput;
    }
}