package open.food.facts.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIE")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "NOM", length = 5000)
	String nom;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	List<Produit> produits;

	public Categorie() {
		produits = new ArrayList<>();
	}

	public Categorie(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
