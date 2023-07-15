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
        try {
            LOGGER.info("getAll");
            return productService.getAllProducts();
        } catch (Exception e) {
            LOGGER.atError().log("getAll: " + e.getMessage(), e);
            throw e;
        }
    }


    @PostMapping(value = "/product", consumes = "application/json")
    public ResponseEntity<Void> add(@RequestBody ProductDto productDto) {
        try {
            LOGGER.info("addProduct: {}", productDto);
            productService.addProduct(productDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.atError().log("addProduct: " + e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/product/{code}/restock/{amount}")
    public ResponseEntity<Void> restockProduct(@PathVariable String code, @PathVariable int amount) {
        try {
            LOGGER.atInfo().addKeyValue("code", code).addKeyValue("amount", amount)
                    .log("restockProduct: code={}, amount={}", code, amount);
            productService.restock(code, amount);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.atError().log("restockProduct: " + e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/product/{code}/sell/{amount}")
    public ResponseEntity<Void> sellProduct(@PathVariable String code, @PathVariable int amount) {
        try {
            LOGGER.atInfo().addKeyValue("code", code).addKeyValue("amount", amount)
                    .log("sellProduct: code={}, amount={}", code, amount);
            productService.sell(code, amount);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            LOGGER.atError().log("sellProduct: " + e.getMessage(), e);
            throw e;
        }
    }
}
