package open.food.facts.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.entites.Categorie;

public class CategorieDAOJdbc implements CategorieDAO {

	private EntityManager em;

	public CategorieDAOJdbc(EntityManager em) {
		this.em = em;
	}

	@Override
	public Categorie getByName(String nom) {
		TypedQuery<Categorie> query = em.createQuery("SELECT c FROM Categorie c WHERE c.nom = :nom", Categorie.class);
		query.setParameter("nom", nom);

		List<Categorie> categories = query.getResultList();
		if (categories.isEmpty()) {

			return null;
		} else {
			return categories.get(0);
		}
	}

}
