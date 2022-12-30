package org.sid.billingservice.feign;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductRestClient {
   /* @GetMapping(path = "/products")
    PagedModel<Product> pageProducts(@RequestParam(value="page") int page, @RequestParam(value="size") int size);*/
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts();
    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);
}
