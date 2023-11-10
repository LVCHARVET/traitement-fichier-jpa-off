package open.food.facts.appli;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import open.food.facts.DAO.CategorieDAO;
import open.food.facts.DAO.CategorieDAOJdbc;
import open.food.facts.DAO.MarqueDAO;
import open.food.facts.DAO.MarqueDAOJdbc;
import open.food.facts.DAO.ProduitDAO;
import open.food.facts.DAO.ProduitDAOJdbc;
import open.food.facts.entites.Categorie;
import open.food.facts.entites.Marque;
import open.food.facts.entites.Produit;

/**
 * Class servant d'affichage à la recherche sur critéres dans la base de donné
 * 
 * @author Louis-Valentin CHARVET
 */
public class MenuAffichageOpenFoodFacts {

	public static void main(String[] args) {

		// Ouverture du scanner du menu
		Scanner scanner = new Scanner(System.in);
		int choix = 0;

		// Connection a la BDD et défénition des DAO
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts");
		EntityManager em = emf.createEntityManager();
		ProduitDAO produitDao = new ProduitDAOJdbc(em);
		CategorieDAO categorieDAO = new CategorieDAOJdbc(em);
		MarqueDAO marqueDao = new MarqueDAOJdbc(em);

		// Affichage du menu et gestion des réponses utilisateurs
		while (choix != 7) {
			System.out.println("Menu :");
			System.out.println("1. Affichez les 10 produits les mieux notés d'une catégorie");
			System.out.println("2. Affichez les 10 produits les mieux notés d'une marque");
			System.out.println(
					"3. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un ingrédient donné");
			System.out.println(
					"4. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un ingrédient donné");
			System.out.println(
					"5. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un allergène donné");
			System.out.println(
					"6. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un allergène donné");
			System.out.println("7. Sortir");
			System.out.print("Veuillez choisir une option : ");
			choix = scanner.nextInt();

			switch (choix) {

			// Recherche sur les 10 produits les mieux notés d'une catégorie
			case 1:

				// Prise de la categorie saisie
				Scanner scannerCategorie = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la categorie : ");
				String nomCategorie = scannerCategorie.nextLine();
				Categorie categorie = categorieDAO.getByName(nomCategorie);

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsCategorie = produitDao.getBestProductParCategorie(categorie);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la catégorie " + categorie.getNom() + " :");
				for (Produit produit : top10ProduitsCategorie) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}

				break;
			case 2:

				// Prise de la marque saisie
				Scanner scannerMarque = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la marque : ");
				String nomMarque = scannerMarque.nextLine();
				Marque marque = marqueDao.getByName(nomMarque);

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsMarque = produitDao.getBestProductParMarque(marque);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la marque " + marque.getNom() + " :");
				for (Produit produit : top10ProduitsMarque) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}

				break;
			case 3:

				// Prise de la categorie saisie
				Scanner scannerCate = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la categorie : ");
				String nomCate = scannerCate.nextLine();
				Categorie cate = categorieDAO.getByName(nomCate);

				// Prise de la l'ingredient saisie
				Scanner scannermCateIngr = new Scanner(System.in);
				System.out.print("Nom de l'ingredient a exclure : ");
				String nomIngredient = scannermCateIngr.nextLine();

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsCateIngre = produitDao.getBestProductParCategorieWithoutIngr(cate,
						nomIngredient);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la catégorie " + cate.getNom()
						+ " sans l'ingredient suivant :" + nomIngredient + " :");
				for (Produit produit : top10ProduitsCateIngre) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}

				break;
			case 4:

				// Prise de la marque saisie
				Scanner scannerMarq = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la marque : ");
				String nomMarq = scannerMarq.nextLine();
				Marque marq = marqueDao.getByName(nomMarq);

				// Prise de la l'ingredient saisie
				Scanner scannermMarqIngr = new Scanner(System.in);
				System.out.print("Nom de l'ingredient a exclure : ");
				String nomIngre = scannermMarqIngr.nextLine();

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsMarqIngre = produitDao.getBestProductParMarqueWithoutIngr(marq, nomIngre);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la marque " + marq.getNom()
						+ " sans l'ingredient suivant :" + nomIngre + " :");
				for (Produit produit : top10ProduitsMarqIngre) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}
				break;
			case 5:

				// Prise de la categorie saisie
				Scanner scannerCateAller = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la categorie : ");
				String nomC = scannerCateAller.nextLine();
				Categorie c = categorieDAO.getByName(nomC);

				// Prise de la l'allergene saisie
				Scanner scannerAllergene = new Scanner(System.in);
				System.out.print("Nom de l'allergene a exclure : ");
				String nomAllergene = scannerAllergene.nextLine();

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsCateAller = produitDao.getBestProductParCategorieWithoutAllerg(c,
						nomAllergene);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la catégorie " + c.getNom()
						+ " sans l'allergene suivante :" + nomAllergene + " :");
				for (Produit produit : top10ProduitsCateAller) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}

				break;
			case 6:

				// Prise de la marque saisie
				Scanner scannerMarqAller = new Scanner(System.in);
				System.out.println("1. Les 10 produits les mieux notés :");
				System.out.print("Nom de la marque : ");
				String nomM = scannerMarqAller.nextLine();
				Marque m = marqueDao.getByName(nomM);

				// Prise de la l'allergene saisie
				Scanner scannerAller = new Scanner(System.in);
				System.out.print("Nom de l'allergene a exclure : ");
				String nomAller = scannerAller.nextLine();

				// Appel de la requete permettant la recherche contenu dans le DAO
				List<Produit> top10ProduitsMarqAller = produitDao.getBestProductParMarqueWithoutAllerg(m, nomAller);

				// Affichage de la réponse
				System.out.println("Les 10 meilleurs produits pour la Marque " + m.getNom()
						+ " sans l'allergene suivante :" + nomAller + " :");
				for (Produit produit : top10ProduitsMarqAller) {
					System.out.println(produit.getNom() + " - Score nutritif : " + produit.getNutritionScore());
				}

				break;
			case 7:

				// Option pour quitter le Menu
				System.out.println("Au revoir !");
				break;
			default:

				// Saisi utilisateur incorrect
				System.out.println("Choix invalide. Veuillez réessayer.");
				break;
			}
		}

		// Fermeture du scanner
		scanner.close();

		// Fermeture de la connection
		emf.close();
		em.close();
	}

}
