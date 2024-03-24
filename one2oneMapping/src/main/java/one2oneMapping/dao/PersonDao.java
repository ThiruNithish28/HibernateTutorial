package one2oneMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneMapping.dto.Person;


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
 
			/* if we don't set id, then it automatically set the default values as 0*/
			person.setId(id);
			/* as same as Id when we don't set the AadharCard then it set as default value as NULL
			 	so, we update or set the AadharCard by " Maintain that old relationship " , 
			 	then Where is the Old AadharCard is present ?
			 	 	it is present in the "personFind" object  i.e; personfind.getAadharCard();
			 */
			person.setAadharCard(personFind.getAadharCard());
			// Now we Update the person by using merge()
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
			em.remove(personFind);
			et.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	
}
