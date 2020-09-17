package io.pivotal.pal.tracker;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalTrackerApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PalTrackerApplication.class);

    @Autowired
    private Person person;

    public static void main (String[] args){
        SpringApplication.run(PalTrackerApplication.class, args);
    }

    public void run(String... args){
        logger.info("Persons Age: "+ person.age);
        logger.info("Persons Name: "+ person.name);
    }

    @Bean
    public TimeEntryRepository getRepo(DataSource dataSource){
        return new JdbcTimeEntryRepository(dataSource);
    }
}
