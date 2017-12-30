package org.ecommerce.order.web.dto;

import java.util.List;

public class ListProductDto {

	private List<ProductDto> productDtoList;

	public ListProductDto() {
	}

	public List<ProductDto> getProductDtoList() {
		return productDtoList;
	}

	public void setProductDtoList(List<ProductDto> productDtoList) {
		this.productDtoList = productDtoList;
	}
}
