package fikranBelajar.fikranBelajarAja.controller;

import fikranBelajar.fikranBelajarAja.models.Customer;
import fikranBelajar.fikranBelajarAja.services.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Customer getCustomerById(@RequestParam Integer id) throws NotFoundException {
        Customer customer =null;
        try {
            customer = customerService.getCustomerById(id);
        }catch (Exception e){
            e.getMessage();
        }
        return customer;
    }
}
