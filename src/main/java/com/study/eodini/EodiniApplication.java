package com.study.eodini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EodiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(EodiniApplication.class, args);
    }

}
