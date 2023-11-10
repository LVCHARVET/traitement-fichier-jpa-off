package open.food.facts.DAO;

import java.util.List;

import open.food.facts.entites.Categorie;
import open.food.facts.entites.Marque;
import open.food.facts.entites.Produit;

public interface ProduitDAO {
	List<Produit> getBestProductParCategorie(Categorie categorie);

	List<Produit> getBestProductParMarque(Marque marque);

	List<Produit> getBestProductParCategorieWithoutIngr(Categorie categorie, String ingredient);

	List<Produit> getBestProductParMarqueWithoutIngr(Marque marque, String ingredient);

	List<Produit> getBestProductParCategorieWithoutAllerg(Categorie categorie, String allergene);
	
	List<Produit> getBestProductParMarqueWithoutAllerg(Marque marque, String allergene);
}
