package org.ecommerce.reverseproxy.benchmark;

import java.util.StringJoiner;

public class ProduitTestDto {

    private long id;
    private String nom;
    private int quantite;

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

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProduitTestDto.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nom='" + nom + "'")
                .add("quantite=" + quantite)
                .toString();
    }
}
