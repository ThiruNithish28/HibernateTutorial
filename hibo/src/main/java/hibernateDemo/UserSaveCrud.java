package hibernateDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

public class UserSaveCrud {

	public static void main(String[] args) {
		
		User user1 = new User();
//		user1.setUserId(1);      // If you use @GeneratedValue then we don't explicit set the id  
		user1.setName("Mohan");
		user1.setAddress("trichy");
		
		User user2 = new User();
		user2.setName("Thiru");
		user2.setAddress("Thanjavur");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(user1);
		et.commit();

	}

}
