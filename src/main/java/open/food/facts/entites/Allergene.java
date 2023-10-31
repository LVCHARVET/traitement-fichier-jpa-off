package open.food.facts.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALLERGENE")
public class Allergene {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "NOM", length = 5000)
	String nom;

	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_ALLERGENE", joinColumns = @JoinColumn(name = "ID_ALLERGENE", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUIT", referencedColumnName = "ID"))
	List<Produit> Produits;

	public Allergene() {
	}

	@Override
	public String toString() {
		return "Allergenes [id=" + id + ", nom=" + nom + ", Produits=" + Produits + "]";
	}

	public Allergene(String nom) {
		this.nom = nom;
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
