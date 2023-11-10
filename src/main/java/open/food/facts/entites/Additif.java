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
@Table(name = "ADDITIF")
public class Additif {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "NOM", length = 5000)
	String nom;

	@ManyToMany(mappedBy = "additifs")
	List<Produit> Produits;

	public Additif() {
	}

	public Additif(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Additif [id=" + id + ", nom=" + nom + ", Produits=" + Produits + "]";
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
		return Produits;
	}

	public void setProduits(List<Produit> produits) {
		Produits = produits;
	}

}
