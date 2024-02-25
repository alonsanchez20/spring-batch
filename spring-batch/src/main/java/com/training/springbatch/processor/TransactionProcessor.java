package com.training.springbatch.processor;

import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;
import com.training.springbatch.writer.TransactionWritter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TransactionProcessor implements ItemProcessor<TransactionInput, TransactionOutput> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProcessor.class);


    @Override
    public TransactionOutput process(TransactionInput item) throws Exception {

        return TransactionOutput.builder()
                .id(item.getId())
                .type(item.getType())
                .amount(item.getAmount())
                .timestamp(item.getTimestamp())
                .reviewed(true)
                .build();
    }
}
