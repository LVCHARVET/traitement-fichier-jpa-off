package open.food.facts.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.entites.Marque;

/**
 * Regroupement des methodes et requetes liés à la classe Marque
 * 
 * @author ShiShi
 *
 */
public class MarqueDAOJdbc implements MarqueDAO {

	/**
	 * Initialisation d'une connection
	 */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public MarqueDAOJdbc(EntityManager em) {
		this.em = em;
	}

	/**
	 * Requete pour trouver une marque par son nom
	 */
	@Override
	public Marque getByName(String nom) {

		// Requete Typé pour trouver la marque
		TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m WHERE m.nom = :nom", Marque.class);
		query.setParameter("nom", nom);

		// Stockage du résultat
		List<Marque> marque = query.getResultList();

		// Verification du resultat et retour
		if (marque.isEmpty()) {
			return null;
		} else {
			return marque.get(0);
		}
	}

}
