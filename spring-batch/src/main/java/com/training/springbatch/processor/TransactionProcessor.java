package com.training.springbatch.processor;

import com.training.springbatch.mapper.DataFormatMapperInterface;
import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionProcessor implements ItemProcessor<TransactionInput, TransactionOutput> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProcessor.class);

    @Autowired
    private DataFormatMapperInterface dataFormatMapperInterface;


    @Override
    public TransactionOutput process(TransactionInput item) throws Exception {

        TransactionOutput transactionOutput = new TransactionOutput();

        transactionOutput.setId(item.getId());
        transactionOutput.setType(item.getType());
        transactionOutput.setAmount(item.getAmount());
        transactionOutput.setTimestamp(dataFormatMapperInterface.dateString2LocalDateTime(item.getTimestamp()));
        transactionOutput.setReviewed(true);

        return transactionOutput;
    }

}
