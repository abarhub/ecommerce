package org.ecommerce.ui.web.dto;

public class UIProductDto {

	private long id;
	private String nom;
	private String code;
	private int quantite;

	public UIProductDto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		return "UIProductDto{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", quantite=" + quantite +
				'}';
	}
}
