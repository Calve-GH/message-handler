package com.github.calvegh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.TimeZone;

@SpringBootApplication
public class SpringBootApp {
    public static void main(String[] args) {
        new SpringApplication(SpringBootApp.class).run(args);
    }
}

