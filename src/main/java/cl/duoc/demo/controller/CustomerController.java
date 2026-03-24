package cl.duoc.demo.controller;

import cl.duoc.demo.model.Customer;
import cl.duoc.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<Customer> findAll(){
        return customerService.findAll();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") int id){
        Customer customer = customerService.findById(id);
        if (customer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<Customer> create(@Valid @RequestBody() Customer customer){
        Customer createdCustomer = customerService.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody() Customer customer){
        customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        customerService.delete(customerService.findById(id));
    }
}
