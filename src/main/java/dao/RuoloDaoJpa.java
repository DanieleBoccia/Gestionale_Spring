package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import model.Ruolo;

@Component
public class RuoloDaoJpa {
	
	EntityManagerFactory emf;
	EntityManager em;
	public RuoloDaoJpa() {
		
		emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
		em = emf.createEntityManager();
	}
	
	public void insert(Ruolo rol) {
		em.getTransaction().begin();
		
		em.persist(rol);
		
		em.getTransaction().commit();
	}
	
	public void update(Ruolo rol) {
		em.getTransaction().begin();
		
		em.merge(rol);
		
		em.getTransaction().commit();
	}
	
	public void delete(int idRuolo) {
	    
	    em.getTransaction().begin();
	    Ruolo rol = em.find(Ruolo.class, idRuolo);
	    em.remove(rol);
	    em.getTransaction().commit();
	    em.close();
	}
	
	public Ruolo find(int idRuolo) {
		em.getTransaction().begin();
		
		Ruolo rol = em.find(Ruolo.class, idRuolo);
		System.out.println("ID : " + rol.getIdRuolo() + " " + "Descrizione : " + rol.getDescrizione());
		return rol;
		
	}
	

}
