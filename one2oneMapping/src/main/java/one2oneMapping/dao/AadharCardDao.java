package one2oneMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneMapping.dto.AadharCard;
import one2oneMapping.dto.Person;

public class AadharCardDao {
	
	public void saveAadharCard(int personId, AadharCard aadharcard) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Person personFind = em.find(Person.class, personId);
		if(personFind != null) {
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			// save the Aadhar card in DB
			em.persist(aadharcard);
			// Update the person
			personFind.setAadharCard(aadharcard);
			et.commit();
		}else {
//			not valid person
			System.out.println("Sorry ID is not present/Person is not present");
		}
	}
	
	public void updateAadharCard(int aadharID, AadharCard aadharcard) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		AadharCard aadharFind = em.find(AadharCard.class, aadharID);
		if(aadharFind != null) {
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			// Update the person
			aadharcard.setId(aadharID);
			em.merge(aadharcard);
			et.commit();
		}else {
//			not valid person
			System.out.println("Sorry ID is not present/Person is not present");
		}
	}
	
	// DELETE AadharCard
	/*
	 		" We can't delete the non owning side first because  UNI-DIRECTION "
	 	If we try to delete this non owing side first it shows some ERROR 
	 	ERROR ->  Cannot delete or update a parent row: a foreign key constraint fails (`mapping`.`person`, CONSTRAINT `FKd5aoterc2dd7bse1jljqefiuw` FOREIGN KEY (`aadharCard_id`) REFERENCES `aadharcard` (`id`))
	 	
	 	because one of the data is present in the Owning side  ie; non-owning side sharing relationship with owning side 
	 	so without deleting the owning side we can't delete 
	 	
	 	Then , To delete the data in non-owning side we must delete the owning data which has a share relationship first then 
	 	we able to delete the non- owning side OtherWise we can't able to delete it. 
	 */
	
public void deleteAadhar(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		AadharCard aadharFind = em.find(AadharCard.class, id);
		if(aadharFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(aadharFind);
			et.commit();
		}else {
			System.out.println("Sorry id is not present");
		}

	}
	

}
