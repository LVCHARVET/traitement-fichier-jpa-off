package open.food.facts.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "NOM", length = 5000)
	String nom;

	@ManyToMany(mappedBy = "ingredients")
	List<Produit> produits;

	public Ingredient() {
	}

	public Ingredient(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
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
