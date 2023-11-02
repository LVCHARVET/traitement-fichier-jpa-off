package open.food.facts.entites;

import java.util.List;

public class RecensementProduit {
	List<Produit> arrayProduit;

	public RecensementProduit(List<Produit> arrayProduit) {
		this.arrayProduit = arrayProduit;
	}

	@Override
	public String toString() {
		return "RecensementProduit [arrayProduit=" + arrayProduit + "]";
	}

	public List<Produit> getArrayProduit() {
		return arrayProduit;
	}

	public void setArrayProduit(List<Produit> arrayProduit) {
		this.arrayProduit = arrayProduit;
	}

}
