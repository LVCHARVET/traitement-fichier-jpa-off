package open.food.facts.DAO;

import java.util.List;

import open.food.facts.entites.Produit;

public interface ProduitDAO {
	List<Produit> extraire();
	void insert(Produit produit);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Produit produit);
}
