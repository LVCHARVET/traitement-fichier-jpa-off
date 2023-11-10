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
 * Définition de la classe Ingredient
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de l'ingredient
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Liste des produits contenant cet ingredient
	 */
	@ManyToMany(mappedBy = "ingredients")
	List<Produit> produits;

	/**
	 * Constructeur pour JPA
	 */
	public Ingredient() {
	}

	/**
	 * Constructeur par le nom
	 * 
	 * @param nom
	 */
	public Ingredient(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + "]";
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
	 * @return liste de produits
	 */
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits
	 */
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
