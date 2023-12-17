package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private boolean useFakeCustomerRepo;
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("Command Line Runner");
        };
    }
    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = "+ useFakeCustomerRepo);
              return   new CustomerFakeRepository();

    }
}
