package one2oneBidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneBidirection.dto.AadharCard;
import one2oneBidirection.dto.Person;
//import one2oneBidirection.dto.Person;

public class AadharCardDao {
	
	public void saveAadharCard(AadharCard aadharcard) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
			et.begin();
	
			em.persist(aadharcard);
		
			et.commit();
		
	}
	
	public void updateAadharCard(int aadharID, AadharCard aadharcard) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		AadharCard aadharFind = em.find(AadharCard.class, aadharID);
		if(aadharFind != null) {
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			// update the new from the old one 
			aadharcard.setPerson(aadharFind.getPerson());
			// Update the person
			aadharcard.setId(aadharID);
			
			em.merge(aadharcard);
			et.commit();
		}else {
//			not valid person
			System.out.println("Sorry ID is not present/Person is not present");
		}
	}

	public void findAadhar(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		AadharCard aadharFind = em.find(AadharCard.class, id);
		if(aadharFind != null) {
			System.out.println(aadharFind);
		}else {
			System.out.println("Sorry id is not present");
		}
	}
public void deleteAadhar(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		AadharCard aadharFind = em.find(AadharCard.class, id);
		if(aadharFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			Person personFind = new Person();
			personFind.setAadharCard(null); // delete the aadhar details in person 
			aadharFind.setPerson(null);
			em.remove(aadharFind);
			et.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	

}
