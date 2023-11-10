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

@Entity
@Table(name = "PRODUIT")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToOne
	@JoinColumn(name = "ID_CATEGORIE")
	Categorie categorie;

	@ManyToOne
	@JoinColumn(name = "ID_MARQUE")
	Marque marque;

	@Column(name = "NOM")
	String nom;

	@Column(name = "NUTRITION_SCORE")
	String nutritionScore;

	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_INGREDIENT", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_INGREDIENT"))
	List<Ingredient> ingredients;

	@Column(name = "ENERGIE")
	String energie;

	@Column(name = "GRAISSE")
	String graisse;

	@Column(name = "SUCRE")
	String sucre;

	@Column(name = "FIBRES")
	String fibres;

	@Column(name = "PROTEINE")
	String proteine;

	@Column(name = "SEL")
	String sel;

	@Column(name = "VITA")
	String vitA;

	@Column(name = "VITD")
	String vitD;

	@Column(name = "VITE")
	String vitE;

	@Column(name = "VITK")
	String vitK;

	@Column(name = "VITC")
	String vitC;

	@Column(name = "VITB1")
	String vitB1;

	@Column(name = "VITB2")
	String vitB2;

	@Column(name = "VITPP")
	String vitPP;

	@Column(name = "VITB6")
	String vitB6;

	@Column(name = "VIB9")
	String vitB9;

	@Column(name = "VITB12")
	String vitB12;

	@Column(name = "CALCIUM")
	String calcium;

	@Column(name = "MAGNESIUM")
	String mangesium;

	@Column(name = "IRON")
	String iron;

	@Column(name = "FER")
	String fer;

	@Column(name = "BETA_CAROTENE")
	String betaCarotene;

	@Column(name = "HUILE_DE_PALME")
	String huileDePalme;

	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_ALLERGENE", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_ALLERGENE"))
	List<Allergene> allergenes;

	@ManyToMany
	@JoinTable(name = "COMPO_PRODUIT_ADDITIF", joinColumns = @JoinColumn(name = "ID_PRODUIT"), inverseJoinColumns = @JoinColumn(name = "ID_ADDITIF"))
	List<Additif> additifs;

	public Produit() {
	}

	public Produit(String nom2, String nutritionScore2, List<Ingredient> arrayIngre, String energie2, String graisse2,
			String sucre2, String fibres2, String proteine2, String sel2, String vitA2, String vitD2, String vitE2,
			String vitK2, String vitC2, String vitB13, String vitB22, String vitPP2, String vitB62, String vitB92,
			String vitB122, String calcium2, String mangesium2, String iron2, String fer2, String betaCarotene2,
			String huileDePalme2, List<Allergene> arrayAllerg, List<Additif> arrayAdd) {
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNutritionScore() {
		return nutritionScore;
	}

	public void setNutritionScore(String nutritionScore) {
		this.nutritionScore = nutritionScore;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public String getGraisse() {
		return graisse;
	}

	public void setGraisse(String graisse) {
		this.graisse = graisse;
	}

	public String getSucre() {
		return sucre;
	}

	public void setSucre(String sucre) {
		this.sucre = sucre;
	}

	public String getFibres() {
		return fibres;
	}

	public void setFibres(String fibres) {
		this.fibres = fibres;
	}

	public String getProteine() {
		return proteine;
	}

	public void setProteine(String proteine) {
		this.proteine = proteine;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}

	public String getVitA() {
		return vitA;
	}

	public void setVitA(String vitA) {
		this.vitA = vitA;
	}

	public String getVitD() {
		return vitD;
	}

	public void setVitD(String vitD) {
		this.vitD = vitD;
	}

	public String getVitE() {
		return vitE;
	}

	public void setVitE(String vitE) {
		this.vitE = vitE;
	}

	public String getVitK() {
		return vitK;
	}

	public void setVitK(String vitK) {
		this.vitK = vitK;
	}

	public String getVitC() {
		return vitC;
	}

	public void setVitC(String vitC) {
		this.vitC = vitC;
	}

	public String getVitB1() {
		return vitB1;
	}

	public void setVitB1(String vitB1) {
		this.vitB1 = vitB1;
	}

	public String getVitB2() {
		return vitB2;
	}

	public void setVitB2(String vitB2) {
		this.vitB2 = vitB2;
	}

	public String getVitPP() {
		return vitPP;
	}

	public void setVitPP(String vitPP) {
		this.vitPP = vitPP;
	}

	public String getVitB6() {
		return vitB6;
	}

	public void setVitB6(String vitB6) {
		this.vitB6 = vitB6;
	}

	public String getVitB9() {
		return vitB9;
	}

	public void setVitB9(String vitB9) {
		this.vitB9 = vitB9;
	}

	public String getVitB12() {
		return vitB12;
	}

	public void setVitB12(String vitB12) {
		this.vitB12 = vitB12;
	}

	public String getCalcium() {
		return calcium;
	}

	public void setCalcium(String calcium) {
		this.calcium = calcium;
	}

	public String getMangesium() {
		return mangesium;
	}

	public void setMangesium(String mangesium) {
		this.mangesium = mangesium;
	}

	public String getIron() {
		return iron;
	}

	public void setIron(String iron) {
		this.iron = iron;
	}

	public String getFer() {
		return fer;
	}

	public void setFer(String fer) {
		this.fer = fer;
	}

	public String getBetaCarotene() {
		return betaCarotene;
	}

	public void setBetaCarotene(String betaCarotene) {
		this.betaCarotene = betaCarotene;
	}

	public String getHuileDePalme() {
		return huileDePalme;
	}

	public void setHuileDePalme(String huileDePalme) {
		this.huileDePalme = huileDePalme;
	}

	public List<Allergene> getAllergenes() {
		return allergenes;
	}

	public void setAllergenes(List<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	public List<Additif> getAdditifs() {
		return additifs;
	}

	public void setAdditifs(List<Additif> additifs) {
		this.additifs = additifs;
	}

}