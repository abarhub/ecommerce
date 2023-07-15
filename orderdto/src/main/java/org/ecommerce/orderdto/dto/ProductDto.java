package org.ecommerce.orderdto.dto;

public class ProductDto {

	private long id;
	private String name;
	private String code;
	private int quantite;

	public ProductDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "ProductDto{" +
				"id=" + id +
				", name='" + name + '\'' +
				", code='" + code + '\'' +
				", quantite=" + quantite +
				'}';
	}
}
