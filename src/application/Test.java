package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		debutTest();
		instancePerson();
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

}
