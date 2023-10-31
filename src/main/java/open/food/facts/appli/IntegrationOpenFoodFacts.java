package open.food.facts.appli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang3.math.NumberUtils;

import open.food.facts.entites.Categorie;
import open.food.facts.entites.Ingredient;
import open.food.facts.entites.Produit;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = emf.createEntityManager();

		List<Produit> arrayProduitGlobal = new ArrayList<Produit>();
		List<Ingredient> arrayIngredientGlobal = new ArrayList<Ingredient>();
		Set<Categorie> arrayCategorieGlobal = new HashSet<>();

		Path pathfile = Paths.get("C:/temp/open-food-facts.csv");

		List<String> lines = Files.readAllLines(pathfile);

		for (int i = 0; i < lines.size(); i++) {
			List<String> arrayIngredient = new ArrayList<>();
			List<Categorie> arrayCategorie = new ArrayList<>();

			String line = lines.get(i);
			String[] tokens = line.split("\\|", -1);

			if (i > 1) {
				Categorie categorie = new Categorie(tokens[0]);				
				String marque = tokens[1];
				String nom = tokens[2];
				String nutritionScore = tokens[3];
				String ingredients = tokens[4];
				String energie = tokens[5];
				String graisse = tokens[6];
				String sucre = tokens[7];
				String fibres = tokens[8];
				String proteine = tokens[9];
				String sel = tokens[10];
				String vitA = tokens[11];
				String vitD = tokens[12];
				String vitE = tokens[13];
				String vitK = tokens[14];
				String vitC = tokens[15];
				String vitB1 = tokens[16];
				String vitB2 = tokens[17];
				String vitPP = tokens[18];
				String vitB6 = tokens[19];
				String vitB9 = tokens[20];
				String vitB12 = tokens[21];
				String calcium = tokens[22];
				String mangesium = tokens[23];
				String iron = tokens[24];
				String fer = tokens[25];
				String betaCarotene = tokens[26];
				String huileDePalme = tokens[27];
				String allergenes = tokens[28];
				String additifs = tokens[29];

				String[] ingredientFiltre1 = ingredients.split("[,;:-]");

				if (ingredientFiltre1.length > 1) {

					for (String chainIngredients : ingredientFiltre1) {

						chainIngredients = chainIngredients.replaceAll("_", "");
						chainIngredients = chainIngredients.replaceAll("\\[.*\\]", " ");
						chainIngredients = chainIngredients.replaceAll("\\(.*\\)", " ");
						chainIngredients = chainIngredients.replaceAll("E\\d", "");
						chainIngredients = chainIngredients.replaceAll("\\d", "");
						chainIngredients = chainIngredients.replaceAll("%", "");
						chainIngredients = chainIngredients.replaceAll("\\.", "");
						chainIngredients = chainIngredients.replaceAll("•", "");
						chainIngredients = chainIngredients.replaceAll("\\*", "");
						chainIngredients = chainIngredients.replaceAll("\\[", "");
						chainIngredients = chainIngredients.replaceAll("\\]", "");
						chainIngredients = chainIngredients.replaceAll("\\(", "");
						chainIngredients = chainIngredients.replaceAll("\\)", "").trim();

						if (chainIngredients.length() > 2) {

							arrayIngredient.add(chainIngredients.toLowerCase());

						}
					}

				}

				if (NumberUtils.isCreatable(energie) && NumberUtils.isCreatable(graisse)) {

					Set<String> triIngredient = new HashSet<>(arrayIngredient);
					List<String> listIngredient = new ArrayList<>(triIngredient);
					List<Ingredient> arrayIngre = new ArrayList<>();

					for (String ingredient : listIngredient) {
						Ingredient ingre = new Ingredient(ingredient);
						arrayIngredientGlobal.add(ingre);
						arrayIngre.add(ingre);
					}

					Produit produit = new Produit(categorie, marque, nom, nutritionScore, arrayIngre, energie, graisse,
							sucre, fibres, proteine, sel, vitA, vitD, vitE, vitK, vitC, vitB1, vitB2, vitPP, vitB6,
							vitB9, vitB12, calcium, mangesium, iron, fer, betaCarotene, huileDePalme, allergenes,
							additifs);

					arrayProduitGlobal.add(produit);

				} else {
					System.out.println(line);
				}

			}
		}

		em.getTransaction().begin();
		for (Ingredient ingredients : arrayIngredientGlobal) {
			em.persist(ingredients);
		}

		for (Produit produits : arrayProduitGlobal) {
			em.persist(produits);
		}

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
