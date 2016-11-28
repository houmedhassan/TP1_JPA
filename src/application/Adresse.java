package application;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Adresse {
	
	private String rue;
	private String codepostal;
	private String ville;
	
	/**
	 * Constructor
	 */
	public Adresse(){
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * 
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * 
	 * @return
	 */
	public String getCodepostal() {
		return codepostal;
	}
	
	/**
	 * 
	 * @param codepostal
	 */
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	/**
	 * 
	 * @return
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * 
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
}
