package org.ecommerce.ui.web.rest;

import org.ecommerce.ui.service.ProductService;
import org.ecommerce.ui.web.dto.ListUIProductDto;
import org.ecommerce.ui.web.dto.UIProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product", produces = "application/json")
    public ListUIProductDto getAll() {
        try {
            LOGGER.info("getAll");
            return productService.getAllProducts();
        } catch (Exception e) {
            LOGGER.atError().log("getAll", e);
            throw e;
        }
    }


    @PostMapping(value = "/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> add(@RequestBody UIProductDto productDto) {
        try {
            LOGGER.info("add:{}", productDto);
            productService.addProduct(productDto);
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.atError().addKeyValue("productDto", productDto)
                    .log("add", e);
            throw e;
        }
    }


    @PutMapping(value = "/product/{code}/restock/{amount}")
    public ResponseEntity<Void> restockProduct(@PathVariable String code, @PathVariable int amount) {
        try {
            LOGGER.atInfo().addKeyValue("code", code).addKeyValue("amount", amount)
                    .log("restock: code={}, amount={}", code, amount);
            productService.restockProduct(code, amount);
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.atError().addKeyValue("code", code).addKeyValue("amount", amount)
                    .log("restockProduct", e);
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
            LOGGER.atError().addKeyValue("code", code).addKeyValue("amount", amount)
                    .log("sellProduct", e);
            throw e;
        }
    }
}
