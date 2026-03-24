package cl.duoc.demo.repository;

import cl.duoc.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private final List<Customer> customers = new ArrayList<Customer>();

    public CustomerRepository() {
         customers.add(new Customer(1, "John Doe", "john@doe.com", "555"));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public Customer getCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }

        return null;
    }

    public Customer updateCustomer(int id, Customer customer) {
        Customer c = getCustomerById(id);
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());

        return c;
    }

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }
}
