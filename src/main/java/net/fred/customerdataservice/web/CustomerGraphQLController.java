package net.fred.customerdataservice.web;

import lombok.AllArgsConstructor;
import net.fred.customerdataservice.dto.CustomerRequest;
import net.fred.customerdataservice.entities.Customer;
import net.fred.customerdataservice.mappers.CustomerMapper;
import net.fred.customerdataservice.repository.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    //Consult Customer List
    @QueryMapping
    public List<Customer> allCustomers(){
        return customerRepository.findAll();
    }

    //Consult one Customer
    @QueryMapping
    public Customer customerById(@Argument Long id){
        Customer customer = customerRepository.findById(id).orElse(null);
        //generate exception, in case customer is empty
        if(customer==null) throw new RuntimeException(String.format("Customer %s not found",id));
        return customer;
    }

    @MutationMapping
    public Customer saveCustomer(@Argument CustomerRequest customer){
        Customer c = customerMapper.from(customer);
        return customerRepository.save(c);
    }
}
