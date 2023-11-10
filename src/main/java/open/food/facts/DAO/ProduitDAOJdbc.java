package open.food.facts.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import open.food.facts.comparator.ProduitComparator;
import open.food.facts.entites.Categorie;
import open.food.facts.entites.Marque;
import open.food.facts.entites.Produit;

/**
 * Regroupement des methodes et requetes liés à la classe Produit
 * 
 * @author ShiShi
 *
 */
public class ProduitDAOJdbc implements ProduitDAO {

	/**
	 * Initialisation d'une connection
	 */
	private EntityManager em;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public ProduitDAOJdbc(EntityManager em) {
		this.em = em;
	}

	// Requete pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie
	public List<Produit> getBestProductParCategorie(Categorie categorie) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p WHERE p.categorie = :categorie ORDER BY p.nutritionScore DESC", Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("categorie", categorie);

		// Limite fixé à 10 resultats
		query.setMaxResults(10);

		// Stockage du résultat
		List<Produit> top10Product = query.getResultList();

		return top10Product;
	}

	// Requete pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque
	public List<Produit> getBestProductParMarque(Marque marque) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p WHERE p.marque = :marque ORDER BY p.nutritionScore DESC", Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("marque", marque);

		// Limite fixé à 10 resultats
		query.setMaxResults(10);

		// Stockage du résultat
		List<Produit> top10Product = query.getResultList();

		return top10Product;
	}

	// requette pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie et ingredient
	@Override
	public List<Produit> getBestProductParCategorieWithoutIngr(Categorie categorie, String ingredient) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p JOIN p.ingredients i WHERE p.categorie = :categorie AND NOT EXISTS (SELECT i FROM Ingredient i WHERE i.nom = :ingredientExclu AND  p MEMBER OF i.produits) ORDER BY p.nutritionScore DESC",
				Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("categorie", categorie);
		query.setParameter("ingredientExclu", ingredient);

		// Gestion des doublons et trie de la liste
		List<Produit> result = query.getResultList();
		Set<Produit> uniqueResults = new HashSet<>(result);
		List<Produit> filterResult = new ArrayList<>(uniqueResults);
		Collections.sort(filterResult, new ProduitComparator());

		// Stockage du résultat imite fixé à 10 resultats
		List<Produit> top10Product = filterResult.subList(0, Math.min(filterResult.size(), 10));

		return top10Product;
	}

	// requette pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque et ingredient
	@Override
	public List<Produit> getBestProductParMarqueWithoutIngr(Marque marque, String ingredient) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p JOIN p.ingredients i WHERE p.marque = :marque AND NOT EXISTS (SELECT i FROM Ingredient i WHERE i.nom = :ingredientExclu AND p MEMBER OF i.produits) ORDER BY p.nutritionScore DESC",
				Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("marque", marque);
		query.setParameter("ingredientExclu", ingredient);

		// Gestion des doublons et trie de la liste
		List<Produit> result = query.getResultList();
		Set<Produit> uniqueResults = new HashSet<>(result);
		List<Produit> filterResult = new ArrayList<>(uniqueResults);
		Collections.sort(filterResult, new ProduitComparator());

		// Stockage du résultat imite fixé à 10 resultats
		List<Produit> top10Product = filterResult.subList(0, Math.min(filterResult.size(), 10));

		return top10Product;
	}

	// requette pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa categorie et allergene
	@Override
	public List<Produit> getBestProductParCategorieWithoutAllerg(Categorie categorie, String allergene) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p JOIN p.allergenes a WHERE p.categorie = :categorie AND NOT EXISTS (SELECT a FROM Allergene a WHERE a.nom = :allergeneExclu AND p MEMBER OF a.Produits) ORDER BY p.nutritionScore DESC",
				Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("categorie", categorie);
		query.setParameter("allergeneExclu", allergene);

		// Gestion des doublons et trie de la liste
		List<Produit> result = query.getResultList();
		Set<Produit> uniqueResults = new HashSet<>(result);
		List<Produit> filterResult = new ArrayList<>(uniqueResults);
		Collections.sort(filterResult, new ProduitComparator());

		// Stockage du résultat imite fixé à 10 resultats
		List<Produit> top10Product = filterResult.subList(0, Math.min(filterResult.size(), 10));

		return top10Product;
	}

	// requette pour effectuer une recherche de 10 produits classés par leurs score
	// nutritif en fonction de sa marque et allergene
	@Override
	public List<Produit> getBestProductParMarqueWithoutAllerg(Marque marque, String allergene) {

		// Requete Typé pour trouver les produits
		TypedQuery<Produit> query = em.createQuery(
				"SELECT p FROM Produit p JOIN p.allergenes a WHERE p.marque = :marque AND NOT EXISTS (SELECT a FROM Allergene a WHERE a.nom = :allergeneExclu AND p MEMBER OF a.Produits) ORDER BY p.nutritionScore DESC",
				Produit.class);

		// Définition des parametres saisi par l'utilisateur
		query.setParameter("marque", marque);
		query.setParameter("allergeneExclu", allergene);

		// Gestion des doublons et trie de la liste
		List<Produit> result = query.getResultList();
		Set<Produit> uniqueResults = new HashSet<>(result);
		List<Produit> filterResult = new ArrayList<>(uniqueResults);
		Collections.sort(filterResult, new ProduitComparator());

		// Stockage du résultat imite fixé à 10 resultats
		List<Produit> top10Product = filterResult.subList(0, Math.min(filterResult.size(), 10));

		return top10Product;
	}

}
