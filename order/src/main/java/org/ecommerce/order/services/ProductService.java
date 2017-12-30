package org.ecommerce.order.services;

import org.ecommerce.order.dao.domain.Product;
import org.ecommerce.order.dao.repository.ProductRepository;
import org.ecommerce.order.web.dto.ListProductDto;
import org.ecommerce.order.web.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
}
