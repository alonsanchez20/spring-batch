package com.training.springbatch.mapper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DataFormatMapperInterfaceImpl implements DataFormatMapperInterface {
    @Override
    public LocalDateTime dateString2LocalDateTime(String date) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);

    }
}
