package org.ecommerce.order.dao.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {

	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "PRODUCT_SEQ"
	)
	@SequenceGenerator(
			name = "PRODUCT_SEQ",
			allocationSize = 1
	)
	private Long id;

	@Column(length = 50)
	@Size(max = 50)
	@NotNull
	private String name;

	@Column
	private int quantite;

	public Product() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
