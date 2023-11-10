package open.food.facts.DAO;

import open.food.facts.entites.Categorie;

/**
 * Interface DAO pour la classe Categorie
 * 
 * @author ShiShi
 *
 */
public interface CategorieDAO {

	// Methode pour trouver une catégorie par son nom
	Categorie getByName(String nom);
}
