package open.food.facts.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.entites.Marque;

public class MarqueDAOJdbc implements MarqueDAO {

	private EntityManager em;

	public MarqueDAOJdbc(EntityManager em) {
		this.em = em;
	}

	@Override
	public Marque getByName(String nom) {
		TypedQuery<Marque> query = em.createQuery("SELECT m FROM Marque m WHERE m.nom = :nom", Marque.class);
		query.setParameter("nom", nom);

		List<Marque> marque = query.getResultList();
		if (marque.isEmpty()) {
			return null;
		} else {
			return marque.get(0);
		}
	}

}
