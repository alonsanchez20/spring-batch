package com.training.springbatch.config;

import com.training.springbatch.listener.TransactionListener;
import com.training.springbatch.model.transaction.TransactionInput;
import com.training.springbatch.model.transaction.TransactionOutput;
import com.training.springbatch.processor.TransactionProcessor;
import com.training.springbatch.repository.TransactionRepository;
import com.training.springbatch.writer.TransactionWritter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private JobRepository jobRepository;

    @Value("${file.input}")
    private String inputJSON;
    public JobLauncher getJobTransactionLauncher() throws Exception {
        TaskExecutorJobLauncher taskExecutorJobLauncher = new TaskExecutorJobLauncher();
        taskExecutorJobLauncher.afterPropertiesSet();
        taskExecutorJobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return taskExecutorJobLauncher;
    }

    @Bean
    public Job processTransactionsJob(TransactionListener listener, Step stepOne){

        return new JobBuilder("processTransactionsJob", jobRepository)
                .listener(listener)
                .flow(stepOne)
                .end()
                .build();
    }

    @Bean
    public Step stepOne(PlatformTransactionManager transactionManager) {


        return new StepBuilder("stepOne", jobRepository)
                .<TransactionInput, TransactionOutput> chunk(5, transactionManager) // procesa en bloques de 5
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public FlatFileItemReader<TransactionInput> reader() {
        return new FlatFileItemReaderBuilder<TransactionInput>()
                .name("transactionItemReader")
                .resource(new ClassPathResource("input.csv"))
                .delimited()
                .names(new String[] { "id", "timestamp", "type", "amount"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<TransactionInput>() {{
                    setTargetType(TransactionInput.class);

                }})
                .build();
    }

    @Bean
    public TransactionProcessor processor() {
        return new TransactionProcessor();
    }

    @Bean
    public TransactionWritter writer() {
        return new TransactionWritter(transactionRepository);
    }

}
