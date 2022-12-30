package org.sid.costumerservice;

import org.sid.costumerservice.entities.Customer;
import org.sid.costumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CostumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration, CustomerRepository customerRepository){
        restConfiguration.exposeIdsFor(Customer.class);

        return args -> {
            customerRepository.save(new Customer(null,"loubna","lou@email.com"));
            customerRepository.save(new Customer(null,"loulou","louaa@email.com"));
            customerRepository.save(new Customer(null,"lala","loua@email.com"));

            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
