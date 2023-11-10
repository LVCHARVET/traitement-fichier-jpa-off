package open.food.facts.comparator;

import java.util.Comparator;

import open.food.facts.entites.Produit;

/**
 * Comparateur servant a trier les produits par score nutritif.
 * 
 * @author Louis-Valentin CHARVET *
 */
public class ProduitComparator implements Comparator<Produit> {

	@Override
	public int compare(Produit p1, Produit p2) {

		// Comparaison enttre deux Produit sur la base de la valeure nutritive
		int scoreComparison = p1.getNutritionScore().compareTo(p2.getNutritionScore());

		// Si score nutritif égale, comparaison éfféctué sur le nom
		if (scoreComparison == 0) {
			return p1.getNom().compareTo(p2.getNom());
		}

		return scoreComparison;
	}
}
