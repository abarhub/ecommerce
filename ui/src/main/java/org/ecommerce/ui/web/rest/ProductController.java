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
        LOGGER.info("getAll");
        return productService.getAllProducts();
    }


    @PostMapping(value = "/product", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> add(@RequestBody UIProductDto productDto) {
        LOGGER.info("add:{}", productDto);
        productService.addProduct(productDto);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(httpHeaders, HttpStatus.OK);
    }


    @PutMapping(value = "/product/{code}/restock/{amount}")
    public ResponseEntity<Void> restockProduct(@PathVariable String code,@PathVariable int amount) {
        LOGGER.info("restock: code={}, amount={}", code, amount);
        productService.restockProduct(code, amount);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(httpHeaders, HttpStatus.OK);
    }

}
