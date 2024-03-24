package one2oneBidirection.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2oneBidirection.dao.AadharCardDao;
import one2oneBidirection.dao.PersonDao;
import one2oneBidirection.dto.AadharCard;
import one2oneBidirection.dto.Person;

public class PersonAadharContr {

	public static void main(String[] args) {
		
//		Person person = new Person();
//		
//		person.setId(1);
//		person.setName("mohan");
//		person.setAddress("trichy");
//		
//		AadharCard aadharcard = new AadharCard();
//		aadharcard.setId(101);
//		aadharcard.setName("Mohan p");
//		aadharcard.setAge(20);
//		
//		person.setAadharCard(aadharcard);
//		aadharcard.setPerson(person);
		
//		PersonDao pDao = new PersonDao();
//		pDao.savePerson(person);
//		AadharCardDao aDao = new AadharCardDao();
//		aDao.saveAadharCard(aadharcard);
			// Note :
		/* 				when we do save operation like above it shows an error becase it is bidirection 
		 so when we persist any one of the two owning side the other one should be present else it shows 
		 an ERROR 
		 		object references an unsaved transient instance - save the transient instance before flushing : one2oneBidirection.dto.Person.aadharCard -> one2oneBidirection.dto.AadharCard
		 so we do the persist operation in One/Single Transaction not be separate like above (savePerson, saveAadharcard).
		 		
		 */
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		em.persist(person);
//		em.persist(aadharcard);
//		et.commit();
		// Now it will save in DB  because both persist operation is perform under single Entity transaction
	
	// Delete: 	
	//  AadharCardDao aDao = new AadharCardDao();
//		aDao.deleteAadhar(101);
		/* we can't delete the aadharcard by normally method we used in other mapping its an exceptional case 
		   check in AadharCard Dao
		*/
		
	//	aDao.findAadhar(101);
		// when we try to find the entity it shows an ERROR called StackOverflow 
		
	/*                                  java.lang.StackOverflowError 
	 
		 it fetch the data but This error is occur only when try to  print the data after fetching
		 Where one to one by default the fetch type be  " EGAER"
		 
		 	Reason for Error:  in tostring()  in person it try to print id , name, address , when come to aadharcard it goes to 
		 aadharCard class and print all properties in aadharCard like id, name, age, then comes to print person so it 
		 goes to Person class , "It goes like Loop " that's why the StackOverFlow error is occur 
      */
		// that means 
		/* 			Where the table  Person we have (id,name,address,A_id) Where as in AadharCard we have (id,name,age,P_id)
		  there are repeated column occurs (two FK- A_id,P_id)
		  to overcome this we to delete the one foreign key but the relationship is remain SAME 
		  
		  ie; it share the column by using 
		  the annotation like @JoinColumns , @OneToOne(mapped by= "")
		  
		  @Entity                                        @Entity
		  Class Person{                                  Class AadharCard{
		  	@Id                                               @Id
		  	id;                                                id;
		  	name;                                              name;
		  	.                                                  age;
		  	.                                                  .
		  	@JoinColumns                                       @OneToOne(mapped by = "aadhar")
		  	@OneToOne                                          Person person;
		  	AadharCard aadhar;                                   
		  	}                                             }
		  	                            
		  	 			When we create table like this  in Person table (id,name,address,A_id) and
		  	 AadharCard table (id,name,age) we remove the column P_id in AadharCard table                                         
		   */
	// Note : Before execute the below code, If the command line exists then Remove the command line in the @Annotation in Dto class	
		Person person = new Person();
		
		person.setId(1);
		person.setName("mohan");
		person.setAddress("trichy");
		
		AadharCard aadharcard = new AadharCard();
		aadharcard.setId(101);
		aadharcard.setName("Mohan p");
		aadharcard.setAge(20);
		
		person.setAadharCard(aadharcard);
		aadharcard.setPerson(person);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(person);
		em.persist(aadharcard);
		et.commit();
	}
}
