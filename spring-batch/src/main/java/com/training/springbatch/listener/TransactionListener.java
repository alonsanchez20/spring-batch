package com.training.springbatch.listener;

import com.training.springbatch.processor.TransactionProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionListener implements JobExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        JobExecutionListener.super.beforeJob(jobExecution);
        LOGGER.info("Job Started");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        JobExecutionListener.super.afterJob(jobExecution);
        LOGGER.info("Job Finished");
    }
}
