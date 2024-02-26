package com.training.springbatch.processor;

import com.training.springbatch.exceptions.InvalidAmountException;
import com.training.springbatch.mapper.DataFormatMapperInterface;
import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;
import com.training.springbatch.service.TransactionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class TransactionProcessor implements ItemProcessor<TransactionInput, TransactionOutput> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProcessor.class);


    @Autowired
    private TransactionValidator transactionValidator;


    @Override
    public TransactionOutput process(TransactionInput item) throws Exception {

        LOGGER.info("Processing item Id: {}", item.getId());

        try {
            return transactionValidator.validateTransaction(item);
        } catch (InvalidAmountException e) {
            LOGGER.error(e.getMessage());
            return null; // Indica a Spring Batch que salte este elemento
        }
    }

}
