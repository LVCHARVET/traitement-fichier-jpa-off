package open.food.facts.DAO;

import open.food.facts.entites.Marque;

public interface MarqueDAO {
	Marque getByName(String nom);
}
