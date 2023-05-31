package com.example.springrelationonetoone.Repository;

import com.example.springrelationonetoone.Model.Cstomer;
import com.example.springrelationonetoone.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerById (Integer id);
}
