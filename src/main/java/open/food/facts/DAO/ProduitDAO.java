package open.food.facts.DAO;

import java.util.List;

import open.food.facts.entites.Categorie;
import open.food.facts.entites.Marque;
import open.food.facts.entites.Produit;

/**
 * Interface DAO pour la classe Produit
 * 
 * @author ShiShi
 *
 */
public interface ProduitDAO {

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie
	List<Produit> getBestProductParCategorie(Categorie categorie);

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque
	List<Produit> getBestProductParMarque(Marque marque);

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie et ingredient
	List<Produit> getBestProductParCategorieWithoutIngr(Categorie categorie, String ingredient);

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque et ingredient
	List<Produit> getBestProductParMarqueWithoutIngr(Marque marque, String ingredient);

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie et allergene
	List<Produit> getBestProductParCategorieWithoutAllerg(Categorie categorie, String allergene);

	// Methode pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque et allergene
	List<Produit> getBestProductParMarqueWithoutAllerg(Marque marque, String allergene);
}
