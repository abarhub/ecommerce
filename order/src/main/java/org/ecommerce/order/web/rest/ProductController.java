package org.ecommerce.order.web.rest;

import org.ecommerce.order.StartUp;
import org.ecommerce.order.services.ProductService;
import org.ecommerce.order.web.dto.ListProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	//@GetMapping(value = "/", produces = "application/json")
	@RequestMapping(value = "/product", produces = "application/json")
	public ListProductDto getAll() {
		LOGGER.info("getAll");
		return productService.getAllProducts();
	}
}
