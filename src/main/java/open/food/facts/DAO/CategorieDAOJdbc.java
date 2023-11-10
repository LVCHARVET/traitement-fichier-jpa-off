package open.food.facts.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.entites.Categorie;

/**
 * Regroupement des methodes et requetes liés à la classe Categorie
 * 
 * @author ShiShi
 *
 */
public class CategorieDAOJdbc implements CategorieDAO {

	/**
	 * Initialisation d'une connection
	 */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public CategorieDAOJdbc(EntityManager em) {
		this.em = em;
	}

	/**
	 * Requete pour trouver une catégorie par son nom
	 */
	@Override
	public Categorie getByName(String nom) {

		// Requete Typé pour trouver la Categorie
		TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class);
		query.setParameter("nom", nom);

		// Stockage du résultat
		List<Categorie> categories = query.getResultList();

		// Verification du resultat et retour
		if (categories.isEmpty()) {
			return null;
		} else {
			return categories.get(0);
		}
	}

}
