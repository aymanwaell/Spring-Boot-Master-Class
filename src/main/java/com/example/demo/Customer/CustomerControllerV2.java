package com.example.demo.Customer;

import com.example.demo.excepetion.ApiRequestException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController
@AllArgsConstructor
public class CustomerControllerV2 {
    private final CustomerServices customerServices;

    @GetMapping
    List<Customer> getCustomer(){
        return customerServices.getCustomers();
    }
    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId")Long id) {

        return customerServices.getCustomer(id);
    }
    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId")Long id) {

        throw new ApiRequestException(
                "ApiRequestException for customer"+" " +id
        );
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody  Customer customer){
        System.out.println("Post Request");
        System.out.println(customer);
    }
    @PutMapping
    void updateNewCustomer(@RequestBody Customer customer){
        System.out.println("Update Request");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId")Long id){
        System.out.println("Delete Request with id "+ id);
    }
}
