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

/**
 * Class servant à la lecture du fichier CSV contenant les informations saisi
 * par les utilisateurs. Et définissant les objets pour l'écriture des
 * informations en base de donné.
 * 
 * @author Louis-Valentin CHARVET
 */
public class IntegrationOpenFoodFacts {

	public static void main(String[] args) throws IOException {

		// Connection a la base de donnée
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = emf.createEntityManager();

		// Définition des tableaux contenant les informations récupéré
		List<Produit> arrayProduitGlobal = new ArrayList<Produit>();
		List<Ingredient> arrayIngredientGlobal = new ArrayList<Ingredient>();
		List<Allergene> arrayAllergeneGlobal = new ArrayList<Allergene>();
		List<Additif> arrayAdditifGlobal = new ArrayList<Additif>();
		List<ErreurSaisie> arrayESGlobal = new ArrayList<>();
		List<Categorie> arrayCategorieGlobal = new ArrayList<Categorie>();
		List<Marque> arrayMarqueGlobal = new ArrayList<Marque>();
		List<String> arrayCategorie = new ArrayList<>();
		List<String> arrayMarque = new ArrayList<>();

		// Chemin vers le fichier csv
		Path pathfile = Paths.get("C:/temp/open-food-facts.csv");

		// Découpe du fichier en ligne
		List<String> lines = Files.readAllLines(pathfile);

		// Boucle sur chaque ligne du fichier
		for (int i = 0; i < lines.size(); i++) {

			// Tableaux instancié des informations
			List<String> arrayIngredient = new ArrayList<>();
			List<String> arrayAllergene = new ArrayList<>();
			List<String> arrayAdditif = new ArrayList<>();

			// Découpe des lignes en token
			String line = lines.get(i);
			String[] tokens = line.split("\\|", -1);

			// Suppression de la premiére ligne du fichier CSV contenant l'entéte du tableau
			if (i > 1) {

				// Récupération des token et assignation des futures variables d'un Produit
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

				// Filtrage des informations saisi par les utilisateurs pour les Ingrédients
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

				// Filtrage des informations saisi par les utilisateurs pour les Allergenes
				String[] allergeneFiltre = allergenes.split(",");

				if (allergeneFiltre.length > 1) {

					for (String chainAllergene : allergeneFiltre) {
						chainAllergene = chainAllergene.replaceAll("E\\d", "");
						chainAllergene = chainAllergene.replaceAll("en:", "").trim();

						arrayAllergene.add(chainAllergene.toLowerCase());
					}

				}

				// Filtrage des informations saisi par les utilisateurs pour les Additifs
				String[] additifFiltre = additifs.split(",");

				if (additifFiltre.length > 1) {

					for (String chainAdditif : additifFiltre) {

						arrayAdditif.add(chainAdditif);
					}

				}

				// Suppression des problémes de saisi
				if (NumberUtils.isCreatable(energie) && NumberUtils.isCreatable(graisse)) {

					// Suppression des doublons dans la liste Ingredient
					Set<String> triIngredient = new HashSet<>(arrayIngredient);
					List<String> listIngredient = new ArrayList<>(triIngredient);
					List<Ingredient> arrayIngre = new ArrayList<>();

					// Définition de l'objet par le nom et insertion dans les tableaux
					for (String ingredient : listIngredient) {
						Ingredient ingre = new Ingredient(ingredient);
						arrayIngredientGlobal.add(ingre);
						arrayIngre.add(ingre);
					}

					// Suppression des doublons dans la liste Allergene
					Set<String> triAllergene = new HashSet<>(arrayAllergene);
					List<String> listAllergene = new ArrayList<>(triAllergene);
					List<Allergene> arrayAllerg = new ArrayList<>();

					// Définition de l'objet par le nom et insertion dans les tableaux
					for (String allergene : listAllergene) {
						Allergene Allerg = new Allergene(allergene);
						arrayAllergeneGlobal.add(Allerg);
						arrayAllerg.add(Allerg);
					}

					// Suppression des doublons dans la liste Additif
					Set<String> triAdditif = new HashSet<>(arrayAdditif);
					List<String> listAdditif = new ArrayList<>(triAdditif);
					List<Additif> arrayAdd = new ArrayList<>();

					// Définition de l'objet par le nom et insertion dans les tableaux
					for (String additif : listAdditif) {
						Additif add = new Additif(additif);
						arrayAdditifGlobal.add(add);
						arrayAdd.add(add);
					}

					// Initialisation du produit actuel
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

					// Insertion en BDD des Ingredients, Allergenes, Additifs, Categorie et Marque
					em.getTransaction().begin();

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
						Categorie newCate = new Categorie(stringCategorie);
						arrayCategorieGlobal.add(newCate);
					}

					for (Categorie categories : arrayCategorieGlobal) {
						if (categories.getNom().equals(stringCategorie)) {
							produit.setCategorie(categories);
							em.persist(categories);
						}
					}

					if (!arrayMarque.contains(stringMarque)) {
						arrayMarque.add(stringMarque);
						Marque newMarque = new Marque(stringMarque);
						arrayMarqueGlobal.add(newMarque);
					}

					for (Marque marques : arrayMarqueGlobal) {
						if (marques.getNom().equals(stringMarque)) {
							produit.setMarque(marques);
							em.persist(marques);
						}
					}

					em.getTransaction().commit();

					// Mise en tableau de l'objet produit
					arrayProduitGlobal.add(produit);

				} else {
					// Recuperation des erreurs de saisi
					ErreurSaisie erreursaisie = new ErreurSaisie(line);
					arrayESGlobal.add(erreursaisie);

				}

			}
		}

		// Insertion en BDD des produits via un tableau pour limiter le nombre
		// d'ouverture de transaction
		em.getTransaction().begin();

		for (Produit produits : arrayProduitGlobal) {
			em.persist(produits);
		}

		em.getTransaction().commit();

		// Insertion en BDD des erreurs de saisi via un tableau pour limiter le nombre
		// d'ouverture de transaction
		em.getTransaction().begin();

		for (ErreurSaisie erreursaisies : arrayESGlobal) {
			em.persist(erreursaisies);
		}

		em.getTransaction().commit();

		// Fermeture de la connection a la BDD
		em.close();
		emf.close();

	}

}
