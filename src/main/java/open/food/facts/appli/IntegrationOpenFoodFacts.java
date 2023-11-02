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

import open.food.facts.entites.Additif;
import open.food.facts.entites.Allergene;
import open.food.facts.entites.Categorie;
import open.food.facts.entites.ErreurSaisie;
import open.food.facts.entites.Ingredient;
import open.food.facts.entites.Marque;
import open.food.facts.entites.Produit;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = emf.createEntityManager();

		List<Produit> arrayProduitGlobal = new ArrayList<Produit>();
		List<Ingredient> arrayIngredientGlobal = new ArrayList<Ingredient>();
		List<Allergene> arrayAllergeneGlobal = new ArrayList<Allergene>();
		List<Additif> arrayAdditifGlobal = new ArrayList<Additif>();
		List<ErreurSaisie> arrayESGlobal = new ArrayList<>();
		List<String> arrayCategorie = new ArrayList<>();
		List<String> arrayMarque = new ArrayList<>();

		Path pathfile = Paths.get("C:/temp/open-food-facts.csv");

		List<String> lines = Files.readAllLines(pathfile);

		for (int i = 0; i < lines.size(); i++) {
			List<String> arrayIngredient = new ArrayList<>();
			List<String> arrayAllergene = new ArrayList<>();
			List<String> arrayAdditif = new ArrayList<>();

			String line = lines.get(i);
			String[] tokens = line.split("\\|", -1);

			if (i > 1) {
				String stringCategorie = tokens[0];
				String stringMarque = tokens[1];
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

				String[] allergeneFiltre = allergenes.split(",");

				if (allergeneFiltre.length > 1) {

					for (String chainAllergene : allergeneFiltre) {
						chainAllergene = chainAllergene.replaceAll("E\\d", "");
						chainAllergene = chainAllergene.replaceAll("en:", "").trim();

						arrayAllergene.add(chainAllergene.toLowerCase());
					}

				}

				String[] additifFiltre = additifs.split(",");

				if (additifFiltre.length > 1) {

					for (String chainAdditif : additifFiltre) {

						arrayAdditif.add(chainAdditif);
					}

				}

				if (NumberUtils.isCreatable(energie) && NumberUtils.isCreatable(graisse)) {

					Set<String> triIngredient = new HashSet<>(arrayIngredient);
					List<String> listIngredient = new ArrayList<>(triIngredient);
					List<Ingredient> arrayIngre = new ArrayList<>();

					for (String ingredient : listIngredient) {
						Ingredient ingre = new Ingredient(ingredient);
						arrayIngre.add(ingre);
					}

					Set<String> triAllergene = new HashSet<>(arrayAllergene);
					List<String> listAllergene = new ArrayList<>(triAllergene);
					List<Allergene> arrayAllerg = new ArrayList<>();

					for (String allergene : listAllergene) {
						Allergene Allerg = new Allergene(allergene);
						arrayAllergeneGlobal.add(Allerg);
						arrayAllerg.add(Allerg);
					}

					Set<String> triAdditif = new HashSet<>(arrayAdditif);
					List<String> listAdditif = new ArrayList<>(triAdditif);
					List<Additif> arrayAdd = new ArrayList<>();

					for (String additif : listAdditif) {
						Additif add = new Additif(additif);
						arrayAdditifGlobal.add(add);
						arrayAdd.add(add);
					}

					em.getTransaction().begin();

					Categorie categorie = new Categorie();
					Marque marque = new Marque();
					Produit produit = new Produit();

					produit.setNom(nom);
					produit.setNutritionScore(nutritionScore);
					produit.setIngredients(arrayIngre);
					produit.setEnergie(energie);
					produit.setGraisse(graisse);
					produit.setSucre(sucre);
					produit.setFibres(fibres);
					produit.setProteine(proteine);
					produit.setSel(sel);
					produit.setVitA(vitA);
					produit.setVitD(vitD);
					produit.setVitE(vitE);
					produit.setVitK(vitK);
					produit.setVitC(vitC);
					produit.setVitB1(vitB1);
					produit.setVitB2(vitB2);
					produit.setVitPP(vitPP);
					produit.setVitB6(vitB6);
					produit.setVitB9(vitB9);
					produit.setVitB12(vitB12);
					produit.setCalcium(calcium);
					produit.setMangesium(mangesium);
					produit.setIron(iron);
					produit.setFer(fer);
					produit.setBetaCarotene(betaCarotene);
					produit.setHuileDePalme(huileDePalme);
					produit.setAllergenes(arrayAllerg);
					produit.setAdditifs(arrayAdd);

					for (Ingredient ingre : arrayIngre) {
						em.persist(ingre);
					}

					for (Allergene aller : arrayAllerg) {
						em.persist(aller);
					}

					for (Additif add : arrayAdd) {
						em.persist(add);
					}

					if (!arrayCategorie.contains(stringCategorie)) {
						arrayCategorie.add(stringCategorie);
						categorie.setNom(stringCategorie);
						em.persist(categorie);
					}

					if (!arrayMarque.contains(stringMarque)) {
						arrayMarque.add(stringMarque);
						marque.setNom(stringMarque);
						em.persist(marque);
					}

					categorie.getProduits().add(produit);
					marque.getProduits().add(produit);
					produit.setCategorie(categorie);
					produit.setMarque(marque);

					em.persist(produit);

					em.getTransaction().commit();

				} else {
					ErreurSaisie erreursaisie = new ErreurSaisie(line);
					arrayESGlobal.add(erreursaisie);

				}

			}
		}

		em.getTransaction().begin();
//		for (Ingredient ingredients : arrayIngredientGlobal) {
//			em.persist(ingredients);
//		}

//		for (Allergene allergenes : arrayAllergeneGlobal) {
//			em.persist(allergenes);
//		}
//
//		for (Additif additifs : arrayAdditifGlobal) {
//			em.persist(additifs);
//		}

//		for (Categorie categories : arrayCategorieGlobal) {
//			em.persist(categories);
//		}
//
//		for (Marque marques : arrayMarqueGlobal) {
//			em.persist(marques);
//		}

//		for (Produit produits : arrayProduitGlobal) {
//			em.persist(produits);
//		}

		for (ErreurSaisie erreursaisies : arrayESGlobal) {
			em.persist(erreursaisies);
		}

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
