package com.dhn;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {
    @Value("${test}")
    private static String test;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
        System.out.println(test);
    }

}
