package com.training.springbatch.mapper;

import java.time.LocalDateTime;

public interface DataFormatMapperInterface {

    LocalDateTime dateString2LocalDateTime(String date);
}
