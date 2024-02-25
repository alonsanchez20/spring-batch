package com.training.springbatch.mapper;

import com.training.springbatch.model.transaction.TransactionInput;
import org.springframework.batch.item.file.LineMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionInputLineMapper implements LineMapper<TransactionInput> {

    @Override
    public TransactionInput mapLine(String line, int lineNumber) throws Exception {
        String[] fields = line.split(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        TransactionInput transactionInput= new TransactionInput();
        transactionInput.setId(BigInteger.valueOf(Long.parseLong(fields[0])));
        transactionInput.setTimestamp(LocalDateTime.parse(fields[1], formatter));
        transactionInput.setType(fields[2]);
        transactionInput.setAmount(new BigDecimal(fields[3]));

        return transactionInput;
    }
}


