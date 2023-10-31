package open.food.facts.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categorie")
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "NOM", length = 5000)
	String nom;
	
	@OneToMany(mappedBy = "categorie")
	List<Produit> produits;

	public Categorie(String nom) {
		this.nom = nom;
	}
	
	

}
