package com.javacodegeeks.example.service;

import com.javacodegeeks.example.entity.Customer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AccountService implements AccountServiceRemote {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Customer createAccount(String firstName, String lastName) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        
        em.persist(customer);
        
        return customer;
    }
}
