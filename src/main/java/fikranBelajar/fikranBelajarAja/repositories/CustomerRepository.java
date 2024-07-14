package fikranBelajar.fikranBelajarAja.repositories;

import fikranBelajar.fikranBelajarAja.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    public Customer searchCustomerByFirstName(String firstName);
    public Customer findByCustomerId(Integer customerId);

}
