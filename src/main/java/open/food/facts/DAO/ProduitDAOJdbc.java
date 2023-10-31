package open.food.facts.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import open.food.facts.entites.Categorie;
import open.food.facts.entites.Produit;
import open.food.facts.erreur.ExceptionTechnique;

public class ProduitDAOJdbc implements ProduitDAO {

	private Connection connection;

	public ProduitDAOJdbc(Connection connection) {
		this.connection = connection;
	}

	public List<Produit> extraire() {
		List<Produit> arrayProduit = new ArrayList<Produit>();
		try {
			Statement stat = connection.createStatement();
			ResultSet curseur = stat.executeQuery(
					"SELECT categorie, marque, nom, nutritionScore, energie, graisse,sucre, fibres, proteine, sel, vitA, vitD, vitE, vitK, vitC, vitB1, vitB2, vitPP, vitB6, vitB9,vitB12, calcium, mangesium, iron, fer, betaCarotene, huileDePalme FROM PRODUIT");
			while (curseur.next()) {
				String stringCategorie = curseur.getString("categorie");
				Categorie categorie = new Categorie(stringCategorie);
				String marque = curseur.getString("marque");
				String nom = curseur.getString("nom");
				String nutritionScore = curseur.getString("nutritionScore");
				String energie = curseur.getString("energie");
				String graisse = curseur.getString("graisse");
				String sucre = curseur.getString("sucre");
				String fibres = curseur.getString("fibres");
				String proteine = curseur.getString("proteine");
				String sel = curseur.getString("sel");
				String vitA = curseur.getString("vitA");
				String vitD = curseur.getString("vitD");
				String vitE = curseur.getString("vitE");
				String vitK = curseur.getString("vitK");
				String vitC = curseur.getString("vitC");
				String vitB1 = curseur.getString("vitB1");
				String vitB2 = curseur.getString("vitB2");
				String vitPP = curseur.getString("vitPP");
				String vitB6 = curseur.getString("vitB6");
				String vitB9 = curseur.getString("vitB9");
				String vitB12 = curseur.getString("vitB12");
				String calcium = curseur.getString("calcium");
				String mangesium = curseur.getString("mangesium");
				String iron = curseur.getString("iron");
				String fer = curseur.getString("fer");
				String betaCarotene = curseur.getString("betaCarotene");
				String huileDePalme = curseur.getString("huileDePalme");

				Produit produitActuel = new Produit(categorie, marque, nom, nutritionScore, energie, graisse, sucre,
						fibres, proteine, sel, vitA, vitD, vitE, vitK, vitC, vitB1, vitB2, vitPP, vitB6, vitB9, vitB12,
						calcium, mangesium, iron, fer, betaCarotene, huileDePalme);
				arrayProduit.add(produitActuel);
			}

			curseur.close();

			stat.close();

		} catch (SQLException e) {
			System.err.println(e.getMessage());

			throw new ExceptionTechnique("Un probléme est survenu lors de la connection a la DB", e);
		}
		System.out.println("connection établi a la bdd : " + connection);
		return arrayProduit;
	}

	public void insert(Produit produit) {
		PreparedStatement insertProduit = null;
		int nb;
		try {

			insertProduit = connection.prepareStatement(
					"INSERT INTO PRODUIT (categorie, marque, nom, nutritionScore, energie, graisse, sucre, fibres, proteine, sel, vitA, vitD, vitE, vitK, vitC, vitB1, vitB2, vitPP, vitB6, vitB9, vitB12, calcium, mangesium, iron, fer, betaCarotene, huileDePalme) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			insertProduit.setObject(1, produit.getCategorie());
			insertProduit.setString(2, produit.getMarque());
			insertProduit.setString(3, produit.getNom());
			insertProduit.setString(4, produit.getNutritionScore());
			insertProduit.setString(6, produit.getEnergie());
			insertProduit.setString(7, produit.getGraisse());
			insertProduit.setString(8, produit.getSucre());
			insertProduit.setString(9, produit.getFibres());
			insertProduit.setString(10, produit.getProteine());
			insertProduit.setString(11, produit.getSel());
			insertProduit.setString(12, produit.getVitA());
			insertProduit.setString(13, produit.getVitD());
			insertProduit.setString(14, produit.getVitE());
			insertProduit.setString(15, produit.getVitK());
			insertProduit.setString(16, produit.getVitC());
			insertProduit.setString(17, produit.getVitB1());
			insertProduit.setString(18, produit.getVitB2());
			insertProduit.setString(19, produit.getVitPP());
			insertProduit.setString(20, produit.getVitB6());
			insertProduit.setString(21, produit.getVitB9());
			insertProduit.setString(22, produit.getVitB12());
			insertProduit.setString(23, produit.getCalcium());
			insertProduit.setString(24, produit.getMangesium());
			insertProduit.setString(25, produit.getIron());
			insertProduit.setString(26, produit.getFer());
			insertProduit.setString(27, produit.getBetaCarotene());
			insertProduit.setString(28, produit.getHuileDePalme());
			nb = insertProduit.executeUpdate();

			insertProduit.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());

			throw new ExceptionTechnique("Un probléme est survenu lors de l'insertion a la DB", e);
		}
		System.out.println(nb);

	}

	public int update(String ancienNom, String nouveauNom) {
		PreparedStatement updateProduit = null;
		int nb;
		try {
			updateProduit = connection.prepareStatement("UPDATE PRODUIT SET nom=? WHERE nom=?");
			updateProduit.setString(1, nouveauNom);
			updateProduit.setString(2, ancienNom);
			nb = updateProduit.executeUpdate();
			updateProduit.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());

			throw new ExceptionTechnique("Un probléme est survenu lors de la modification d'élément vers la DB", e);
		}
		System.out.println(nb);

		return nb;
	}

	public boolean delete(Produit produit) {

		PreparedStatement deleteProduit = null;
		int nb;
		try {
			deleteProduit = connection.prepareStatement("DELETE FROM PRODUIT WHERE NOM=?");
			deleteProduit.setString(1, produit.getNom());
			nb = deleteProduit.executeUpdate();
			deleteProduit.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());

			throw new ExceptionTechnique("Un probléme est survenu lors de la suppression d'élément vers la DB", e);
		}
		System.out.println(nb);
		return false;
	}

}
