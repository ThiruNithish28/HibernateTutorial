package hibernateDemo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class UserUpdate {
	
	//Note :
			/*       Merge method is used to update the data
			  	it will work based on Primary Key. 
			  		-> if the primary key is present in the data then it will UPDATE the data
			  		-> if the primary key is not present then it will INSERT the data
			  		
			  	to Overcome this we have FIND the data based on that primary key first 
			  	by using find() method
			  		-> if the data is present then only we update 
			  		-> else we we don't update 
			 */

	public static void main(String[] args) {
		
		User userToUpdate = new User();
		userToUpdate.setAddress("trichy");
		userToUpdate.setName("Mohan");
	//	userToUpdate.setUserId(10);   
		/* when we declare id directly may be misconfusion in userToUpdate.setId() with  em.find(User.class, id) 
		   will occur 
		   ie:  User userToUpdate = new User();
				userToUpdate.setAddress("trichy");
				userToUpdate.setName("Mohan"); 
				userToUpdate.setId(10); // where the id 10  is not present in DB
				...
				...
				
				User userFind = em.find(User.class, 2); // where this id is present in DB ,
			so it insert the userToUpdate data
				
		so we create a updateMethod and get id as argument and check that id and set that id 
		*/
		
		UserUpdate userUpdate = new UserUpdate();
		userUpdate.updateUser(1, userToUpdate);
		
	}
	
public void updateUser(int id , User userToUpdate) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
	EntityManager em = emf.createEntityManager();
	
	User userFind = em.find(User.class, id); // to overcome insert we have to check is it already present
	
	if(userFind != null) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		userToUpdate.setUserId(id); 
		/* If we not setUserId then id value is set as default value (0) 
			ie;  
				0 Mohan trichy 
		*/
		em.merge(userToUpdate);
		et.commit();
	}
	else {
		System.out.println("Sorry! the UserId is not in DB");
	}
}

}
