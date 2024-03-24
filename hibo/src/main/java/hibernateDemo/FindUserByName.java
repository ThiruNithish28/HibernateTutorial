package hibernateDemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindUserByName {
	
	//Note: 
/*    		when we want to find the data we use find() method but it search the data based on primary key only.
	 if you want to find based on other then primary key we use "jpql"(Java Persistence Query Language).
	 
	 ie;
	 	 sql  ->  SELECT * FROM user WHERE name = "kfgjig" ;
	 	 jpql ->  SELECT u FROM user u WHERE u.name =?1 ;             here u -> reference variable
*/

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
		EntityManager em =  emf.createEntityManager();
		
		Query query =em.createQuery( "SELECT u FROM User u WHERE u.name = ?1"); 
		// where Query has a entire obj which we find it may be single data or multiple data 
		String name ="Mohan";
		query.setParameter(1, name);
		
		// when the name is unique -> then only use " query.getSingleResult() "
		/*
		 * User user = (User) query.getSingleResult(); 
		 * System.out.println(user);
		 */
		 
		
		// when we have more than 1 result we have a list of result  -> then use query.getResultList() 
		
		   List<User> listOfUser = query.getResultList();
		   System.out.println(listOfUser);
		 
	}

}
