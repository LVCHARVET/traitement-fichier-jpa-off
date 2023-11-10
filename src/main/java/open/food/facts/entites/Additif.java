package open.food.facts.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Définition de la classe Additif
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "ADDITIF")
public class Additif {
	
	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de l'additif
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Liste des produits contenant cet additif
	 */
	@ManyToMany(mappedBy = "additifs")
	List<Produit> Produits;

	/**
	 * Constructeur pour JPA
	 */
	public Additif() {
	}

	/**
	 * Constructeur par le nom
	 * @param nom
	 */
	public Additif(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Additif [id=" + id + ", nom=" + nom + ", Produits=" + Produits + "]";
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return Liste de produit
	 */
	public List<Produit> getProduits() {
		return Produits;
	}

	/**
	 * @param produits
	 */
	public void setProduits(List<Produit> produits) {
		Produits = produits;
	}

}
