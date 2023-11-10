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
 * Définition de la classe Allergene
 * 
 * @author Louis-Valentin CHARVET
 *
 */
@Entity
@Table(name = "ALLERGENE")
public class Allergene {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de l'allergene
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Liste des produits contenant cet allergene
	 */
	@ManyToMany(mappedBy = "allergenes")
	List<Produit> Produits;

	/**
	 * Constructeur pour JPA
	 */
	public Allergene() {
	}

	/**
	 * Constructeur par le nom
	 * 
	 * @param nom
	 */
	public Allergene(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Allergenes [id=" + id + ", nom=" + nom + "]";
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
		return Produits;
	}

	/**
	 * @param produits
	 */
	public void setProduits(List<Produit> produits) {
		Produits = produits;
	}

}
