package com.example.demo.Customer;

import com.example.demo.excepetion.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServices {

    private final CustomerRepository customerRepository;

    List<Customer> getCustomers(){
        log.info("Get Customer was called");
        return customerRepository.findAll();
    }
    Customer getCustomer(@PathVariable("customerId")Long id){
        return customerRepository.findById(id)
                .orElseThrow(
                        ()->{
                            NotFoundException notFoundException = new NotFoundException(
                                    "Customer with id "+ id + " not found"
                            );
                            log.error("error in getting customer {}",id,notFoundException);
                            return notFoundException;
                        });
    }
}
