package org.ecommerce.order.dao.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
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

	@Column(length = 50,unique = true)
	@Size(max = 50)
	@NotNull
	private String code;

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
}
