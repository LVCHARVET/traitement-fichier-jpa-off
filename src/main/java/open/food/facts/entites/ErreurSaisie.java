package open.food.facts.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Définition de la classe ErreurSaisie
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "ERREUR_SAISIE")
public class ErreurSaisie {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Nom de l'erreur de saisie
	 */
	@Column(name = "NOM", length = 5000)
	String nom;

	/**
	 * Constructeur pour JPA
	 */
	public ErreurSaisie() {
	}

	/**
	 * Constructeur par le nom
	 * 
	 * @param nom
	 */
	public ErreurSaisie(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "ErreurSaisie [id=" + id + ", nom=" + nom + "]";
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
