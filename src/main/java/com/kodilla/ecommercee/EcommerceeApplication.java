package com.kodilla.ecommercee;

import com.kodilla.ecommercee.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={
        "com.kodilla.ecommercee.*"})
public class EcommerceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceeApplication.class, args);
    }



}

