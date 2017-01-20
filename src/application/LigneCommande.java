package application;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	private Article article;
	
	private Integer quantite;
	
	
	public LigneCommande(){	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	
	

}
