package org.sid.inventoryservice;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Hp",5678,1));
            productRepository.save(new Product(null,"Sony",9387,1));
            productRepository.save(new Product(null,"Tefal",2000,3));
            productRepository.save(new Product(null,"Hp",5678,1));
            productRepository.save(new Product(null,"Sony",9387,1));
            productRepository.save(new Product(null,"Tefal",2000,3));
            productRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private double prix;
    private double qte;


}
@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product,Long>{
}