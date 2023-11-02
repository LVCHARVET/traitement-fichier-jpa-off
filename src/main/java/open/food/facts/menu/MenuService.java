package open.food.facts.menu;

import java.util.Scanner;

import open.food.facts.entites.RecensementProduit;

public abstract class MenuService {

	public abstract void traiter(RecensementProduit rp, Scanner scanner);

}
