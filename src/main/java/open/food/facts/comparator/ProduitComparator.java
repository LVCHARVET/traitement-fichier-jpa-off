package open.food.facts.comparator;

import java.util.Comparator;

import open.food.facts.entites.Produit;

public class ProduitComparator implements Comparator<Produit> {

	@Override
	public int compare(Produit p1, Produit p2) {
		int scoreComparison = p1.getNutritionScore().compareTo(p2.getNutritionScore());
		if (scoreComparison == 0) {
			return p1.getNom().compareTo(p2.getNom());
		}

		return scoreComparison;
	}
}
