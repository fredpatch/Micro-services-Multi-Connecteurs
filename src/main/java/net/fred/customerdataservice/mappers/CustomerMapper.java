package net.fred.customerdataservice.mappers;

import net.fred.customerdataservice.dto.CustomerRequest;
import net.fred.customerdataservice.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private ModelMapper modelMapper = new ModelMapper();
    public Customer from(CustomerRequest customerRequest){
        //Customer customer = new Customer();
        //customer.setName(customerRequest.name());
        //customer.setEmail(customerRequest.email());
        return modelMapper.map(customerRequest,Customer.class);
    }
}
