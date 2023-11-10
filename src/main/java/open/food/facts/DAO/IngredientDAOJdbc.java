package open.food.facts.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.entites.Ingredient;

public class IngredientDAOJdbc implements IngredientDAO {
	private EntityManager em;

	public IngredientDAOJdbc(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Ingredient getByName(String nom) {
		TypedQuery<Ingredient> query = em.createQuery("SELECT i FROM Ingredient i WHERE i.nom = :nom",
				Ingredient.class);
		query.setParameter("nom", nom);

		List<Ingredient> ingredient = query.getResultList();
		if (ingredient.isEmpty()) {

			return null;
		} else {
			return ingredient.get(0);
		}
	}

}
