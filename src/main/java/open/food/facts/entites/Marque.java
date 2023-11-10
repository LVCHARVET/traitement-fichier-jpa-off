package open.food.facts.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Définition de la classe Marque
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "MARQUE")
public class Marque {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de la marque
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Liste des produits portant cette marque
	 */
	@OneToMany(mappedBy = "marque")
	List<Produit> produits;

	/**
	 * Constructeur pour JPA
	 */
	public Marque() {
		produits = new ArrayList<>();
	}

	/**
	 * Constructeur par le nom
	 * 
	 * @param nom
	 */
	public Marque(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Marque [id=" + id + ", nom=" + nom + ", produits=" + produits + "]";
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
	 * @return liste des produits
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
