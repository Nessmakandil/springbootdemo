package com.example.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.CustomerDao;
import com.example.entities.Customer;


@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public void inserCustomer(Customer customer) {
		this.customerDao.insertCustomer(customer);
	}
	
	 public Customer getCustomerById(int id) {
		 return this.customerDao.getCustomerById(id);
	    }

	public List<Customer> getAllCustomers() {
        return this.customerDao.getAllCustomers();
    }
	
    public void updateCustomer(Customer customer) {
        this.customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer) {
        this.customerDao.deleteCustomer(customer);
    }

    public List<Customer> searchCustomersByFirstName(String firstName) {
        return this.customerDao.searchCustomersByFirstName(firstName);
    }
    
//    public List<Customer> searchCustomersByLastName(String lastName) {
//        return this.customerDao.searchCustomersByLastName(lastName);
//    }
    
    public List<Customer> getAllCustomersSortedBy(String sortByField) {
        return this.customerDao.getAllCustomersSortedBy(sortByField);
    }
}
