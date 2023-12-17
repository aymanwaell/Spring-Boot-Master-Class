package com.example.demo.Customer;

import com.example.demo.DemoApplication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@RequestMapping(path = "api/v1/customer")
@RestController
@Deprecated
@AllArgsConstructor
public class CustomerController {
    private final CustomerServices customerServices;

    @GetMapping(value = "all")
    List<Customer> getCustomer(){
        return customerServices.getCustomers();
    }
    @PostMapping
    void createNewCustomer(@RequestBody Customer customer){
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
