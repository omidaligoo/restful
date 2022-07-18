package com.java.ticket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@SpringBootApplication
@EnableScheduling
public class TicketApplication {
      private static final Logger LOGGER = LoggerFactory.getLogger(TicketApplication.class);
    public static void main(String[] args) {
       SpringApplication.run(TicketApplication.class, args);
        LOGGER.trace("for tracing purpose");
        LOGGER.debug("for debugging purpose");
        LOGGER.info("for informational purpose");
        LOGGER.warn("for warning purpose");
        LOGGER.error("for logging errors");
    }
}


