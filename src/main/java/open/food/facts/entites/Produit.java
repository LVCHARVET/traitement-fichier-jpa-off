package open.food.facts.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Définition de la classe Produit
 * 
 * @author ShiShi
 *
 */
@Entity
@Table(name = "PRODUIT")
public class Produit {

	/**
	 * Identifiant généré automatiquement en BDD
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	/**
	 * Categorie du produit
	 */
	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIE")
	Categorie categorie;

	/**
	 * Marque du produit
	 */
	@ManyToOne
	@JoinColumn(name = "ID_MARQUE")
	Marque marque;

	/**
	 * Nom du produit
	 */
	@Column(name = "NOM")
	String nom;

	/**
	 * Valeure nutritive du produit
	 */
	@Column(name = "NUTRITION_SCORE")
	String nutritionScore;

	/**
	 * Liste des ingredients contenu dans le produit
	 */
	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_INGREDIENT", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT"))
	List<Ingredient> ingredients;

	/**
	 * Energie contenu dans le produit
	 */
	@Column(name = "ENERGIE")
	String energie;

	/**
	 * Graisse contenu dans le produit
	 */
	@Column(name = "GRAISSE")
	String graisse;

	/**
	 * Sucre contenu dans le produit
	 */
	@Column(name = "SUCRE")
	String sucre;

	/**
	 * Fibre contenu dans le produit
	 */
	@Column(name = "FIBRES")
	String fibres;

	/**
	 * Proteine contenu dans le produit
	 */
	@Column(name = "PROTEINE")
	String proteine;

	/**
	 * Sel contenu dans le produit
	 */
	@Column(name = "SEL")
	String sel;

	/**
	 * Vitamine A contenu dans le produit
	 */
	@Column(name = "VITA")
	String vitA;

	/**
	 * Vitamine D contenu dans le produit
	 */
	@Column(name = "VITD")
	String vitD;

	/**
	 * Vitamine E contenu dans le produit
	 */
	@Column(name = "VITE")
	String vitE;

	/**
	 * Vitamine K contenu dans le produit
	 */
	@Column(name = "VITK")
	String vitK;

	/**
	 * Vitamine C contenu dans le produit
	 */
	@Column(name = "VITC")
	String vitC;

	/**
	 * Vitamine B1 contenu dans le produit
	 */
	@Column(name = "VITB1")
	String vitB1;
	/**
	 * Vitamine B2 contenu dans le produit
	 */
	@Column(name = "VITB2")
	String vitB2;

	/**
	 * Vitamine PP contenu dans le produit
	 */
	@Column(name = "VITPP")
	String vitPP;

	/**
	 * Vitamine B6 contenu dans le produit
	 */
	@Column(name = "VITB6")
	String vitB6;

	/**
	 * Vitamine B9 contenu dans le produit
	 */
	@Column(name = "VIB9")
	String vitB9;

	/**
	 * Vitamine B12 contenu dans le produit
	 */
	@Column(name = "VITB12")
	String vitB12;

	/**
	 * Calcium contenu dans le produit
	 */
	@Column(name = "CALCIUM")
	String calcium;

	/**
	 * Magnesium contenu dans le produit
	 */
	@Column(name = "MAGNESIUM")
	String mangesium;

	/**
	 * Iron contenu dans le produit
	 */
	@Column(name = "IRON")
	String iron;

	/**
	 * Fer contenu dans le produit
	 */
	@Column(name = "FER")
	String fer;

	/**
	 * Beta Carotene contenu dans le produit
	 */
	@Column(name = "BETA_CAROTENE")
	String betaCarotene;

	/**
	 * Huile de Palme contenu dans le produit
	 */
	@Column(name = "HUILE_DE_PALME")
	String huileDePalme;

	/**
	 * Liste des allergenes contenu dans le produit
	 */
	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_ALLERGENE", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_ALLERGENE"))
	List<Allergene> allergenes;

	/**
	 * Liste des additifs contenu dans le produit
	 */
	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_ADDITIF", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_ADDITIF"))
	List<Additif> additifs;

	/**
	 * Constructeur pour JPA
	 */
	public Produit() {
	}

	/**
	 * Constructeur pour la création de produit sans la catégorie et la marque
	 * 
	 * @param nom2
	 * @param nutritionScore2
	 * @param arrayIngre
	 * @param energie2
	 * @param graisse2
	 * @param sucre2
	 * @param fibres2
	 * @param proteine2
	 * @param sel2
	 * @param vitA2
	 * @param vitD2
	 * @param vitE2
	 * @param vitK2
	 * @param vitC2
	 * @param vitB13
	 * @param vitB22
	 * @param vitPP2
	 * @param vitB62
	 * @param vitB92
	 * @param vitB122
	 * @param calcium2
	 * @param mangesium2
	 * @param iron2
	 * @param fer2
	 * @param betaCarotene2
	 * @param huileDePalme2
	 * @param arrayAllerg
	 * @param arrayAdd
	 */
	public Produit(String nom2, String nutritionScore2, List<Ingredient> arrayIngre, String energie2, String graisse2,
			String sucre2, String fibres2, String proteine2, String sel2, String vitA2, String vitD2, String vitE2,
			String vitK2, String vitC2, String vitB13, String vitB22, String vitPP2, String vitB62, String vitB92,
			String vitB122, String calcium2, String mangesium2, String iron2, String fer2, String betaCarotene2,
			String huileDePalme2, List<Allergene> arrayAllerg, List<Additif> arrayAdd) {
	}

	/**
	 * Constructeur pour la création de produit avec la catégorie et la marque
	 * 
	 * @param newCategorie
	 * @param newMarque
	 * @param nom2
	 * @param nutritionScore2
	 * @param arrayIngre
	 * @param energie2
	 * @param graisse2
	 * @param sucre2
	 * @param fibres2
	 * @param proteine2
	 * @param sel2
	 * @param vitA2
	 * @param vitD2
	 * @param vitE2
	 * @param vitK2
	 * @param vitC2
	 * @param vitB13
	 * @param vitB22
	 * @param vitPP2
	 * @param vitB62
	 * @param vitB92
	 * @param vitB122
	 * @param calcium2
	 * @param mangesium2
	 * @param iron2
	 * @param fer2
	 * @param betaCarotene2
	 * @param huileDePalme2
	 * @param arrayAllerg
	 * @param arrayAdd
	 */
	public Produit(Categorie newCategorie, Marque newMarque, String nom2, String nutritionScore2,
			List<Ingredient> arrayIngre, String energie2, String graisse2, String sucre2, String fibres2,
			String proteine2, String sel2, String vitA2, String vitD2, String vitE2, String vitK2, String vitC2,
			String vitB13, String vitB22, String vitPP2, String vitB62, String vitB92, String vitB122, String calcium2,
			String mangesium2, String iron2, String fer2, String betaCarotene2, String huileDePalme2,
			List<Allergene> arrayAllerg, List<Additif> arrayAdd) {
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", categorie=" + categorie + ", marque=" + marque + ", nom=" + nom
				+ ", nutritionScore=" + nutritionScore + ", energie=" + energie + ", graisse=" + graisse + ", sucre="
				+ sucre + ", fibres=" + fibres + ", proteine=" + proteine + ", sel=" + sel + ", vitA=" + vitA
				+ ", vitD=" + vitD + ", vitE=" + vitE + ", vitK=" + vitK + ", vitC=" + vitC + ", vitB1=" + vitB1
				+ ", vitB2=" + vitB2 + ", vitPP=" + vitPP + ", vitB6=" + vitB6 + ", vitB9=" + vitB9 + ", vitB12="
				+ vitB12 + ", calcium=" + calcium + ", mangesium=" + mangesium + ", iron=" + iron + ", fer=" + fer
				+ ", betaCarotene=" + betaCarotene + ", huileDePalme=" + huileDePalme + ", additifs=" + additifs + "]";
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return nutritionScore
	 */
	public String getNutritionScore() {
		return nutritionScore;
	}

	/**
	 * @param nutritionScore
	 */
	public void setNutritionScore(String nutritionScore) {
		this.nutritionScore = nutritionScore;
	}

	/**
	 * @return Liste des ingredients
	 */
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients
	 */
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return fibres
	 */
	public String getEnergie() {
		return energie;
	}

	/**
	 * @param energie
	 */
	public void setEnergie(String energie) {
		this.energie = energie;
	}

	/**
	 * @return
	 */
	public String getGraisse() {
		return graisse;
	}

	/**
	 * @param graisse
	 */
	public void setGraisse(String graisse) {
		this.graisse = graisse;
	}

	/**
	 * @return
	 */
	public String getSucre() {
		return sucre;
	}

	/**
	 * @param sucre
	 */
	public void setSucre(String sucre) {
		this.sucre = sucre;
	}

	/**
	 * @return
	 */
	public String getFibres() {
		return fibres;
	}

	/**
	 * @param fibres
	 */
	public void setFibres(String fibres) {
		this.fibres = fibres;
	}

	/**
	 * @return proteine
	 */
	public String getProteine() {
		return proteine;
	}

	/**
	 * @param proteine
	 */
	public void setProteine(String proteine) {
		this.proteine = proteine;
	}

	/**
	 * @return sel
	 */
	public String getSel() {
		return sel;
	}

	/**
	 * @param sel
	 */
	public void setSel(String sel) {
		this.sel = sel;
	}

	/**
	 * @return vitA
	 */
	public String getVitA() {
		return vitA;
	}

	/**
	 * @param vitA
	 */
	public void setVitA(String vitA) {
		this.vitA = vitA;
	}

	/**
	 * @return vitD
	 */
	public String getVitD() {
		return vitD;
	}

	/**
	 * @param vitD
	 */
	public void setVitD(String vitD) {
		this.vitD = vitD;
	}

	/**
	 * @return vitE
	 */
	public String getVitE() {
		return vitE;
	}

	/**
	 * @param vitE
	 */
	public void setVitE(String vitE) {
		this.vitE = vitE;
	}

	/**
	 * @return vitK
	 */
	public String getVitK() {
		return vitK;
	}

	/**
	 * @param vitK
	 */
	public void setVitK(String vitK) {
		this.vitK = vitK;
	}

	/**
	 * @return vitC
	 */
	public String getVitC() {
		return vitC;
	}

	/**
	 * @param vitC
	 */
	public void setVitC(String vitC) {
		this.vitC = vitC;
	}

	/**
	 * @return vitB1
	 */
	public String getVitB1() {
		return vitB1;
	}

	/**
	 * @param vitB1
	 */
	public void setVitB1(String vitB1) {
		this.vitB1 = vitB1;
	}

	/**
	 * @return vitB2
	 */
	public String getVitB2() {
		return vitB2;
	}

	/**
	 * @param vitB2
	 */
	public void setVitB2(String vitB2) {
		this.vitB2 = vitB2;
	}

	/**
	 * @return vitPP
	 */
	public String getVitPP() {
		return vitPP;
	}

	/**
	 * @param vitPP
	 */
	public void setVitPP(String vitPP) {
		this.vitPP = vitPP;
	}

	/**
	 * @return vitB6
	 */
	public String getVitB6() {
		return vitB6;
	}

	/**
	 * @param vitB6
	 */
	public void setVitB6(String vitB6) {
		this.vitB6 = vitB6;
	}

	/**
	 * @return vitB9
	 */
	public String getVitB9() {
		return vitB9;
	}

	/**
	 * @param vitB9
	 */
	public void setVitB9(String vitB9) {
		this.vitB9 = vitB9;
	}

	/**
	 * @return vitB12
	 */
	public String getVitB12() {
		return vitB12;
	}

	/**
	 * @param vitB12
	 */
	public void setVitB12(String vitB12) {
		this.vitB12 = vitB12;
	}

	/**
	 * @return calcium
	 */
	public String getCalcium() {
		return calcium;
	}

	/**
	 * @param calcium
	 */
	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}

	/**
	 * @return mangesium
	 */
	public String getMangesium() {
		return mangesium;
	}

	/**
	 * @param mangesium
	 */
	public void setMangesium(String mangesium) {
		this.mangesium = mangesium;
	}

	/**
	 * @return iron
	 */
	public String getIron() {
		return iron;
	}

	/**
	 * @param iron
	 */
	public void setIron(String iron) {
		this.iron = iron;
	}

	/**
	 * @return fer
	 */
	public String getFer() {
		return fer;
	}

	/**
	 * @param fer
	 */
	public void setFer(String fer) {
		this.fer = fer;
	}

	/**
	 * @return betaCarotene
	 */
	public String getBetaCarotene() {
		return betaCarotene;
	}

	/**
	 * @param betaCarotene
	 */
	public void setBetaCarotene(String betaCarotene) {
		this.betaCarotene = betaCarotene;
	}

	/**
	 * @return huileDePalme
	 */
	public String getHuileDePalme() {
		return huileDePalme;
	}

	/**
	 * @param huileDePalme
	 */
	public void setHuileDePalme(String huileDePalme) {
		this.huileDePalme = huileDePalme;
	}

	/**
	 * @return Liste des allergenes
	 */
	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * @param allergenes
	 */
	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/**
	 * @return List d'additifs
	 */
	public List<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * @param additifs
	 */
	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

}