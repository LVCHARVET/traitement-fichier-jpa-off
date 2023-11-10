package open.food.facts.DAO;

import open.food.facts.entites.Categorie;

public interface CategorieDAO {
	Categorie getByName(String nom);
}
