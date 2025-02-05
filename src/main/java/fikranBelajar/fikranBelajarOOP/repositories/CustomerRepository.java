package fikranBelajar.fikranBelajarOOP.repositories;

import fikranBelajar.fikranBelajarOOP.models.Customer;
import javassist.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer searchCustomerByFirstName(String firstName);
    public Customer findByCustomerId(Integer customerId) throws NotFoundException;

}
