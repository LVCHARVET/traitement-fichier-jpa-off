package open.food.facts.DAO;

import open.food.facts.entites.Ingredient;

public interface IngredientDAO {
	Ingredient getByName(String nom);
}
