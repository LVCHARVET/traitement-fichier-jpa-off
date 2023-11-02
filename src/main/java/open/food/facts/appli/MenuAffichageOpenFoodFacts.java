package open.food.facts.appli;

import java.util.Scanner;

import open.food.facts.menu.MenuService;

public class MenuAffichageOpenFoodFacts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choix = 0;
//
//		while (choix != 7) {
//			System.out.println("Menu :");
//			System.out.println("1. Affichez les 10 produits les mieux notés d'une catégorie");
//			System.out.println("2. Affichez les 10 produits les mieux notés d'une marque");
//			System.out.println(
//					"3. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un ingrédient donné");
//			System.out.println(
//					"4. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un ingrédient donné");
//			System.out.println(
//					"5. Affichez les 10 produits les mieux notés d’une catégorie et qui ne contiennent pas un allergène donné");
//			System.out.println(
//					"6. Affichez les 10 produits les mieux notés d’une marque et qui ne contiennent pas un allergène donné");
//			System.out.println("7. Sortir");
//			System.out.print("Veuillez choisir une option : ");
//			choix = scanner.nextInt();
//
//			switch (choix) {
//			case 1:
//				Scanner scannerUniqueVille = new Scanner(System.in);
//				System.out.println("1. Population d'une ville donnée");
//				System.out.print("Nom de ville : ");
//				MenuService rechercheVille = new MenuUniqueVille();
//				rechercheVille.traiter(recensementVille, scannerUniqueVille);
//				break;
//			case 2:
//				Scanner scannerUniqueDepartement = new Scanner(System.in);
//				System.out.println("2. Population d'un département donné");
//				System.out.print("Numéro de département : ");
//				MenuService rechercheDepartement = new MenuPopDepartement();
//				rechercheDepartement.traiter(recensementVille, scannerUniqueDepartement);
//				break;
//			case 3:
//				Scanner scannerUniqueRegion = new Scanner(System.in);
//				System.out.println("3. Population d'une région donnée");
//				System.out.print("Numéro de région : ");
//				MenuService rechercheRegion = new MenuPopRegion();
//				rechercheRegion.traiter(recensementVille, scannerUniqueRegion);
//				break;
//			case 4:
//				Scanner scannerMaxPopRegion = new Scanner(System.in);
//				System.out.println("4. Afficher les 10 régions les plus peuplées");
//				System.out.print("Appuyer sur n'importe quel chiffre : ");
//				MenuService rechercheMaxPopRegion = new MenuMaxPopRegion();
//				rechercheMaxPopRegion.traiter(recensementVille, scannerMaxPopRegion);
//				break;
//			case 5:
//				Scanner scannerMaxPopDepartement = new Scanner(System.in);
//				System.out.println("5. Afficher les 10 départements les plus peuplés");
//				System.out.print("Appuyer sur n'importe quel chiffre : ");
//				MenuService rechercheMaxPopDepartement = new MenuMaxPopDepartement();
//				rechercheMaxPopDepartement.traiter(recensementVille, scannerMaxPopDepartement);
//				break;
//			case 6:
//				Scanner scannerMaxPopVilleDepartement = new Scanner(System.in);
//				System.out.println("6. Afficher les 10 villes les plus peuplées d'un département");
//				System.out.print("Numéro de département : ");
//				MenuService rechercheMaxPopVilleDepartement = new MenuMaxPopVilleDepartement();
//				rechercheMaxPopVilleDepartement.traiter(recensementVille, scannerMaxPopVilleDepartement);
//				break;
//			case 7:
//				Scanner scannerMaxPopVilleRegion = new Scanner(System.in);
//				System.out.println("7. Afficher les 10 villes les plus peuplées d'une région");
//				System.out.print("Numéro de région : ");
//				MenuService rechercheMaxPopVilleRegion = new MenuMaxPopVilleRegion();
//				rechercheMaxPopVilleRegion.traiter(recensementVille, scannerMaxPopVilleRegion);
//				break;
//			default:
//				System.out.println("Choix invalide. Veuillez réessayer.");
//				break;
//			}
//		}
//		scanner.close();
//
	}

}
