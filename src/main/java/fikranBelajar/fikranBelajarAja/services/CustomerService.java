package fikranBelajar.fikranBelajarAja.services;

import fikranBelajar.fikranBelajarAja.models.Customer;
import fikranBelajar.fikranBelajarAja.repositories.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomer(String firstName){
        return customerRepository.searchCustomerByFirstName(firstName);
    }

    public Customer editCustomer(Customer customer) throws NotFoundException {
        Customer customerCurrent = customerRepository.findById(customer.getCustomerId())
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        customerCurrent.setFirstName(defaultValue(customer.getFirstName()));
        customerCurrent.setMiddleName(defaultValue(customer.getMiddleName()));
        customerCurrent.setLastName(defaultValue(customer.getLastName()));

        return customerRepository.save(customerCurrent);
    }

    private String defaultValue(String value) {
        if(value == null){
            value ="Default";
        }
        return value;
    }
    public Customer getCustomerById(Integer id){
        return customerRepository.findByCustomerId(id);
    }
}
