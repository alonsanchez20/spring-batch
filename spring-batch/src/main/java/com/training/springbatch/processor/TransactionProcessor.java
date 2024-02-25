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

        TransactionOutput transactionOutput = new TransactionOutput();

        transactionOutput.setId(item.getId());
        transactionOutput.setType(item.getType());
        transactionOutput.setAmount(item.getAmount());
        transactionOutput.setTimestamp(item.getTimestamp());
        transactionOutput.setReviewed(true);

        return transactionOutput;
    }
}
