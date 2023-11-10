package open.food.facts.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Définition de la classe Categorie
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "CATEGORIE")
public class Categorie {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de la categorie
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Constructeur pour JPA
	 */
	public Categorie() {
	}

	/**
	 * Constructeur par le nom
	 * 
	 * @param nom
	 */
	public Categorie(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
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

}
