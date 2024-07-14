package fikranBelajar.fikranBelajarOOP.controller;

import fikranBelajar.fikranBelajarOOP.models.Customer;
import fikranBelajar.fikranBelajarOOP.services.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class CustomerController {


    @Autowired
    private CustomerService customerService;
    private ResponseEntity<String> success(){
        String response = "BERHASIL";
        return ResponseEntity.ok(response);
    }


    @PostMapping("/addCustomer")
    public Customer insertCustomer(@RequestBody Customer customer) {
        try {
            if(customer.getCreatedDate() == null){
                customer.setCreatedDate(LocalDateTime.now());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return customerService.insertCustomer(customer);
    }


    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam String firstName) {
        Customer customer =null;
        try {
            customer = customerService.findCustomer(firstName);

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return customer;
    }

    @PutMapping("/editCustomer")
    public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer)throws NotFoundException {
        Customer editCustomer =customerService.editCustomer(customer);
        return ResponseEntity.ok(editCustomer);
    }

    @GetMapping("/getCustomerById")
    public ResponseEntity<Object> getCustomerById(@RequestParam Integer id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer); // Return customer if found
        } catch (NotFoundException e) {
            // Return a JSON response with the error message and 404 status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
