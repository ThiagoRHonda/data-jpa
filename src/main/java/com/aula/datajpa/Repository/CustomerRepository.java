package com.aula.datajpa.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aula.datajpa.Model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
