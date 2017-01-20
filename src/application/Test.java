package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import application.Personne;



public class Test {

	private static EntityManagerFactory emf;
	private static EntityManager em, em1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		debutTest();
			instancePerson();
			modifier1Personne();
			//modifier2Personne();
		
		finTest();
	}
	
	public static void debutTest(){
		emf = Persistence.createEntityManagerFactory("jpa");
		
		em = emf.createEntityManager();
	}
	
	public static void finTest(){
		em.close();
		emf.close();
	}
	
	public static void instancePerson(){
		Personne p1 = new Personne();
//		p1.setId(1);
		p1.setNom("HASSAN MOHAMED");
		List <String> prenoms = new ArrayList<String>();
		prenoms.add("Houmed");
		prenoms.add("houmed saqal");
		prenoms.add("inahaba");
		
		Map<TypeAdresse, Adresse> adresses  = new HashMap<TypeAdresse, Adresse>();
		Adresse adresse1 = new Adresse();
		adresse1.setVille("Djibouti");
		adresse1.setCodepostal("0099");
		adresse1.setRue("saline ouest");
		
		Adresse adresse2 = new Adresse();
		adresse2.setVille("Marseille");
		adresse2.setCodepostal("13009");
		adresse2.setRue("171 avenue de Luminy");
		
		adresses.put(TypeAdresse.PRINCIPALE, adresse1);
		adresses.put(TypeAdresse.SECONDAIRE, adresse2);
		
		p1.setPrenoms(prenoms);
		p1.setAdresses(adresses);
		
		Date date = new Date();
		String datee= "10/10/2015";
		//date = 
		//SimpleDateFormat format = new SimpleDateFormat();
		p1.setDateNaissance(new Date(1821,01,21));
		p1.setCivilite(Civilite.CELIBATAIRE);
		em.getTransaction().begin();
		em.persist(p1);
		em.getTransaction().commit();
	}
	
	/**
	 * modifie l'entite personne precedemment créee de façon a supprimer son premier prenom et modifier sa civilité
	 */
	public static void modifier1Personne(){
		Personne pers = em.getReference(Personne.class, 1);
		
		pers.getPrenoms().remove(0);
		
		pers.setCivilite(Civilite.DIVORCE);
		
		pers.getAdresses().get(TypeAdresse.PRINCIPALE).setCodepostal("69007");
		pers.getAdresses().get(TypeAdresse.PRINCIPALE).setRue("2 rue de michelet");
		pers.getAdresses().get(TypeAdresse.PRINCIPALE).setVille("lyon");
		
		// on ouvre une transaction JPA puis on persist.
		em.getTransaction().begin();
		em.persist(pers);
		em.getTransaction().commit();
		
	}
	
	/**
	 * modifie l'entite personne 
	 */
	public static void modifier2Personne(){
		
	// interroger le contexte de persistance pour retourver l'entité et l'affecter à une variable locale
		Personne per = em.getReference(Personne.class, 1);
		
	// fermeture du gestionnaire d'entités
		em.close();
		
	// creation d'un nouveau gestionnaire d'entités
		 em1 = emf.createEntityManager();
	
	//modification l'entite (exemple nom)
		per.setNom("papa");
		
	//rendre persistante les modifications.
		
		em1.getTransaction().begin();
		em1.persist(per);
		em1.getTransaction().commit();
		em1.close();
		
	}
	
	/**
	 * supprimer l'entité Personne de la base des données.
	 */
	public static void delete(){
		// interroger le contexte de persistance pour retourver l'entité et l'affecter à une variable locale
		Personne per = em.getReference(Personne.class, 1);
		
		em.getTransaction().begin();
		em.remove(per);
		em.getTransaction().commit();
	}

}
