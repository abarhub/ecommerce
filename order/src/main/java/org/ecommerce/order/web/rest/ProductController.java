package org.ecommerce.order.web.rest;

import org.ecommerce.order.services.ProductService;
import org.ecommerce.orderdto.dto.ListProductDto;
import org.ecommerce.orderdto.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "product", produces = "application/json")
    //@RequestMapping(value = "/product", produces = "application/json")
    public ListProductDto getAll() {
        LOGGER.info("getAll");
        return productService.getAllProducts();
    }


    @PostMapping(value = "/product", consumes = "application/json")
    public ResponseEntity<Void> add(@RequestBody ProductDto productDto) {
        LOGGER.info("addProduct: {}", productDto);
        productService.addProduct(productDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/product/{code}/restock/{amount}")
    public ResponseEntity<Void> restockProduct(@PathVariable String code, @PathVariable int amount) {
        LOGGER.atInfo().addKeyValue("code", code).addKeyValue("amount", amount)
                .log("restockProduct: code={}, amount={}", code, amount);
        productService.restock(code, amount);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/product/{code}/sell/{amount}")
    public ResponseEntity<Void> sellProduct(@PathVariable String code, @PathVariable int amount) {
        LOGGER.info("sellProduct: code={}, amount={}", code, amount);
        productService.sell(code, amount);
        return ResponseEntity.ok().build();
    }
}
