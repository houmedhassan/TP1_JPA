package application;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Sport {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	
	@ManyToMany
	private List<Personne> personne;
	
	public Sport(){	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Personne> getPersonne() {
		return personne;
	}
	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}
	
	
}
