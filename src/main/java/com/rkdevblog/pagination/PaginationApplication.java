package com.rkdevblog.pagination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;

@SpringBootApplication
public class PaginationApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaginationApplication.class, args);
  }

  @Bean
  public Faker getFaker() {
    return new Faker();
  }

}
