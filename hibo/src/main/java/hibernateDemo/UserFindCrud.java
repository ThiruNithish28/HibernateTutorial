package hibernateDemo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;

public class UserFindCrud {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
		EntityManager em = emf.createEntityManager();
		    /*Here while find the data we don't need EntityTransaction 
		so we ignore it 
		//EntityTransaction et = em.getTransaction(); 
		*/

		User user = em.find(User.class, 1);
		if(user!=null)
			System.out.println(user);
		else 
			System.out.println("Sorry ! enter Id is not in DB");

	}

}
