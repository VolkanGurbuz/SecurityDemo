package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SecurityDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecurityDemoApplication.class, args);
  }
}
