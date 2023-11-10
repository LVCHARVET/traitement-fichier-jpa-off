package open.food.facts.DAO;

import open.food.facts.entites.Marque;

/**
 * Interface DAO pour la classe Marque
 * 
 * @author ShiShi
 *
 */
public interface MarqueDAO {
	
	// Methode pour trouver une marque par son nom
	Marque getByName(String nom);
}
