package com.mn.index;

import ccsfr.boot.SimpleApplication;
import ccsfr.boot.annotation.EnableFileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFileService
public class IndexApplication extends SimpleApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndexApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
