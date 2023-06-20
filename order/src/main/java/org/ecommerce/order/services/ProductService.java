package org.ecommerce.order.services;

import jakarta.transaction.Transactional;
import org.ecommerce.order.dao.domain.Product;
import org.ecommerce.order.dao.repository.ProductRepository;
import org.ecommerce.orderdto.dto.ListProductDto;
import org.ecommerce.orderdto.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * get all products
	 *
	 * @return all products
	 */
	@Transactional
	public ListProductDto getAllProducts() {
		ListProductDto listProductDto = new ListProductDto();
		listProductDto.setProductDtoList(new ArrayList<>());

		Iterable<Product> iterable = productRepository.findAll();
		if (iterable != null) {
			for (Product product : iterable) {

				ProductDto productDto = new ProductDto();
				productDto.setId(product.getId());
				productDto.setName(product.getName());
				productDto.setQuantite(product.getQuantite());

				listProductDto.getProductDtoList().add(productDto);
			}
		}

		return listProductDto;
	}

	@Transactional
	public void addProduct(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setQuantite(productDto.getQuantite());
		productRepository.save(product);
	}
}
