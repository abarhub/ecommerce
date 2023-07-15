package org.ecommerce.ui.service;

import org.ecommerce.orderdto.dto.ListProductDto;
import org.ecommerce.orderdto.dto.ProductDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("order")
public interface OrderRestService {

	//@RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
	//Store update(@PathVariable("storeId") Long storeId, Store store);

	@RequestMapping(method = RequestMethod.GET, value = "/product", consumes = "application/json")
	ListProductDto getAll();

	@RequestMapping(method = RequestMethod.POST, value = "/product", consumes = "application/json")
	void addProduct(@RequestBody ProductDto productDto);


	@RequestMapping(method = RequestMethod.PUT, value = "/product/{code}/restock/{amount}", consumes = "application/json")
	void restockProduct(@PathVariable("code") String code, @PathVariable("amount") int amount);

	@RequestMapping(method = RequestMethod.PUT, value = "/product/{code}/sell/{amount}", consumes = "application/json")
	void sell(@PathVariable("code") String code, @PathVariable("amount") int amount);

}
