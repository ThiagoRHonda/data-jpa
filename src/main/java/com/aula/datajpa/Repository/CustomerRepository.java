package com.aula.datajpa.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aula.datajpa.Model.Customer;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    //List<Customer> findByLastName(String lastName);

    Customer findById(long id);

    List<Customer> findByLastName(@Param("customer") String name);

    List<Customer> findByFirstName(@Param("customer") String name);
}
