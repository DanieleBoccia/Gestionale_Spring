package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import model.Storico;

@Component
public class StoricoDaoJpa {
	
	EntityManagerFactory emf;
	EntityManager em;
	public StoricoDaoJpa() {
		
		emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	public void insert(Storico str) {
		em.getTransaction().begin();
		
		em.persist(str);
		
		em.getTransaction().commit();
	}
	
	public void update(Storico str) {
		em.getTransaction().begin();
		
		em.merge(str);
		
		em.getTransaction().commit();
	}
	
	public void delete(int idStorico) {
	    
	    em.getTransaction().begin();
	    Storico str = em.find(Storico.class, idStorico);
	    em.remove(str);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public Storico find(int idStorico) {
		em.getTransaction().begin();
		
		Storico str = em.find(Storico.class, idStorico);
		System.out.println("ID STORICO : " + str.getIdStorico() + "ID RUOLO : " + str.getIdRuolo() + "MATRICOLA : " + str.getMatricola() + "DATA INIZIO : " + str.getDataInizio() + "DATA FINE : " + str.getDataFine());
		return str;
		
	}
	

}


