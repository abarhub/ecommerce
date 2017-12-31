package org.ecommerce.orderdto.dto;

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

	@Override
	public String toString() {
		return "ListProductDto{" +
				"productDtoList=" + productDtoList +
				'}';
	}
}
