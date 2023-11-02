package open.food.facts.menu;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import open.food.facts.entites.Produit;
import open.food.facts.entites.RecensementProduit;

public class MenuRechercheMarque extends MenuService {

	public MenuRechercheMarque() {
	}

	@Override
	public void traiter(RecensementProduit rp, Scanner scanner) {
		List<Produit> arrayProduit = rp.getArrayProduit();
		HashMap<String, String> comptageCategorie = new HashMap<>();
		for (Produit produits : arrayProduit) {
			String categorie = produits.getMarque().getNom();
			if (comptageCategorie.containsKey(categorie)) {
				comptageCategorie.put(categorie, comptageCategorie.get(categorie) + produits.getNom());
			} else {
				comptageCategorie.put(categorie, produits.getNom());
			}
		}
		List<Map.Entry<String, String>> sortedCategorie = comptageCategorie.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());
		int limit = 10;
		for (int i = 0; i < Math.min(limit, sortedCategorie.size()); i++) {
			Map.Entry<String, String> entry = sortedCategorie.get(i);
			String categorie = entry.getKey();
			String produit = entry.getValue();
			System.out.println(categorie + ": " + produit + " habitants");
		}
	}

}
