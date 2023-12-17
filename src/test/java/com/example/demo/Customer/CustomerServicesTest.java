package com.example.demo.Customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServicesTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerServices underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerServices(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer Jamila = new Customer(
                1L,
                "jamila",
                "hello",
                "jamila@gmail.com");
        Customer Sayed = new Customer(
                4L,
                "sayed",
                "hello",
                "sayed@gmail.com");
        customerRepository.saveAll(Arrays.asList(Jamila,Sayed));
        List<Customer> customers = underTest.getCustomers();
        assertEquals(2,customers.size());
    }

    @Test
    void getCustomer() {
        Customer Jamila = new Customer(
                1L,
                "jamila",
                "hello",
                "jamila@gmail.com");
        customerRepository.save(Jamila);
        Customer actual = underTest.getCustomer(1L);
        assertEquals(1L,actual.getId());
        assertEquals("jamila",actual.getName());
    }
}