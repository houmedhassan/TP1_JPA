package application;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import application.LigneCommande;
import application.Personne;

@Entity
public class Commande implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToMany
	private Set<LigneCommande> lignesCommande;
	
	@OneToOne
	private Personne personnes;
	
	public Commande(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(Set<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Personne getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne personnes) {
		this.personnes = personnes;
	}
	
	

}
