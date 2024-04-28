package com.example.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Customer;

import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insertCustomer(Customer customer) {
        entityManager.persist(customer);
    }

    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("FROM Customer", Customer.class)
                            .getResultList();
    }

   @Transactional
    public void updateCustomer(Customer customer) {
        entityManager.merge(customer);
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
    }

    public List<Customer> searchCustomersByFirstName(String firstName) {
        return entityManager.createQuery("FROM Customer WHERE firstName = :firstName", Customer.class)
                            .setParameter("firstName", firstName)
                            .getResultList();
    }

    public List<Customer> getAllCustomersSortedBy(String sortByField) {
        return entityManager.createQuery("FROM Customer ORDER BY " + sortByField, Customer.class)
                            .getResultList();
    }
}
