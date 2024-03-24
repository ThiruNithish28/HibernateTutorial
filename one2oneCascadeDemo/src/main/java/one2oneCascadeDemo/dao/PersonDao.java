package one2oneCascadeDemo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneCascadeDemo.dto.Person;

public class PersonDao {

	public EntityManager getManager() {
		return Persistence.createEntityManagerFactory("CascadeDemo").createEntityManager();
	}
	
	public void savePerson(Person person) {
		EntityManager em = getManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(person);
		
		et.commit();
		
	}
	
	public void updatePerson(int id , Person updatePerson) {
		EntityManager em = getManager();
		Person personFind = em.find(Person.class, id);
		
		if(personFind != null) {
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			
			updatePerson.setId(id);
			em.merge(updatePerson);
			
			et.commit();
		}else {
			System.out.println("Sorry! the id is not found");
		}
	}
	
	public void findPerson(int id) {
		EntityManager em = getManager();
		Person personFind = em.find(Person.class, id);
		
		if(personFind != null) {
			System.out.println(personFind);
		}else {
			System.out.println("Sorry! the id is not found");
		}
	}
	
	public void deletePerson(int id) {
		EntityManager em = getManager();
		Person personFind = em.find(Person.class, id);
		
		if(personFind != null) {
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			
			
			em.remove(personFind);
			
			et.commit();
		}else {
			System.out.println("Sorry! the id is not found");
		}
	}
}
