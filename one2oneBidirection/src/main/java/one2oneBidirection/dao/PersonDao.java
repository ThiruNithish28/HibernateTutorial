package one2oneBidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneBidirection.dto.AadharCard;
import one2oneBidirection.dto.Person;


public class PersonDao {

	public void savePerson(Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(person);
		et.commit();
	}
	
	public void updatePerson(int id , Person person) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		Person personFind = em.find(Person.class, id);
		if(personFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();

			person.setId(id);
			
			person.setAadharCard(personFind.getAadharCard());

			em.merge(person);
			
			et.commit();
		}
	}
	
	public void findPerson(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		Person personFind = em.find(Person.class, id);
		if (personFind != null) {
				System.out.println(personFind);
			} else {
				System.out.println("Sorry Id is not present");
			}
	}
	
	public void deletePerson(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		Person personFind = em.find(Person.class, id);
		if(personFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			AadharCard aadharFind = new AadharCard();
			aadharFind.setPerson(null); // set the person as null in aadhar 
			em.remove(personFind);
			et.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
}
