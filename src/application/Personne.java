package application;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Personne {
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	
	@ElementCollection
	private List<String> prenoms;
	
	@ElementCollection
	private Map<TypeAdresse, Adresse> adresses;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private Civilite civilite;
	
	// association plusieurs-plusieurs
	@ManyToMany
	private List <Sport> sport;
	
	//association Plusieurs-Un
	@OneToMany
	private List<Commande> commande;
	
	/**
	 * Constructor
	 */
	public Personne(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * 
	 * @return
	 */
	public List<String> getPrenoms() {
		return prenoms;
	}
	/**
	 * 
	 * @param prenoms
	 */
	public void setPrenoms(List<String> prenoms) {
		this.prenoms = prenoms;
	}
	/**
	 * 
	 * @return
	 */
	public Map<TypeAdresse, Adresse> getAdresses() {
		return adresses;
	}
	/**
	 * 
	 * @param adresses
	 */
	public void setAdresses(Map<TypeAdresse, Adresse> adresses) {
		this.adresses = adresses;
	}
	/**
	 * 
	 * @return
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * 
	 * @param dateNaissance
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * 
	 * @return
	 */
	public Civilite getCivilite() {
		return civilite;
	}
	/**
	 */
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public List<Sport> getSport() {
		return sport;
	}

	public void setSport(List<Sport> sport) {
		this.sport = sport;
	}
	
	
}
