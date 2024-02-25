package com.training.springbatch.writer;

import com.training.springbatch.model.transaction.TransactionOutput;
import com.training.springbatch.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionWritter implements ItemWriter<TransactionOutput> {

    private final TransactionRepository transactionRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionWritter.class);

    public TransactionWritter(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void write(Chunk<? extends TransactionOutput> transactionOutputs) throws Exception {

        for (TransactionOutput transaction : transactionOutputs) {

            transactionRepository.save(transaction);

        }
    }

}
