package net.fred.customerdataservice;

import net.fred.customerdataservice.entities.Customer;
import net.fred.customerdataservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerDataServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("David Johns")
                    .email("f.johns@gmail.com").build());

            customerRepository.save(Customer.builder().name("Alex Cobbs")
                    .email("kirby@gmail.com").build());

            customerRepository.save(Customer.builder().name("Patchelli Loubendje Carmel Fred")
                    .email("f.patchelli@gmail.com").build());
        };
    }
}
