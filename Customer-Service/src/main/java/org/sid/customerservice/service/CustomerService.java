package org.sid.customerservice.service;


import org.sid.customerservice.entity.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
