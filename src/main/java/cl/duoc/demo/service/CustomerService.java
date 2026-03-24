package cl.duoc.demo.service;

import cl.duoc.demo.model.Customer;
import cl.duoc.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.getCustomers();
    }

    public Customer findById(int id){
        return customerRepository.getCustomerById(id);
    }

    public Customer create(Customer customer){
        return customerRepository.addCustomer(customer);
    }

    public void update(int id, Customer customer){
        customerRepository.updateCustomer(id, customer);
    }

    public void delete(Customer customer){
        customerRepository.deleteCustomer(customer);
    }
}
