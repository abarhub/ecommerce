package org.ecommerce.ui.service;

import org.ecommerce.orderdto.dto.ListProductDto;
import org.ecommerce.orderdto.dto.ProductDto;
import org.ecommerce.ui.web.dto.ListUIProductDto;
import org.ecommerce.ui.web.dto.UIProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private OrderRestService orderRestService;

	public ListUIProductDto getAllProducts() {
		LOGGER.info("getAllProducts");
		ListUIProductDto listUIProductDto = new ListUIProductDto();
		listUIProductDto.setUiProductDtoList(new ArrayList<>());

		ListProductDto liste = orderRestService.getAll();

		if (liste != null && liste.getProductDtoList() != null) {
			for (ProductDto productDto : liste.getProductDtoList()) {
				UIProductDto uiProductDto = new UIProductDto();
				uiProductDto.setId(productDto.getId());
				uiProductDto.setNom(productDto.getName());
				uiProductDto.setQuantite(productDto.getQuantite());
				uiProductDto.setCode(productDto.getCode());
				listUIProductDto.getUiProductDtoList().add(uiProductDto);
			}
		}

		return listUIProductDto;
	}

	public void addProduct(UIProductDto uiProductDto) {
		LOGGER.info("addProduct");

		ProductDto productDto = new ProductDto();
		productDto.setName(uiProductDto.getNom());
		productDto.setCode(uiProductDto.getCode());
		productDto.setQuantite(uiProductDto.getQuantite());

		orderRestService.addProduct(productDto);
	}

	public void restockProduct(String code, int amount) {
		orderRestService.restockProduct(code,amount);
	}
}
