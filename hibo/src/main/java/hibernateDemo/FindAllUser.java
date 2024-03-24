package hibernateDemo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllUser {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select u from User u");
		List<User> userList = query.getResultList();
		
		for(User user : userList) {
			System.out.println(user);
		}

	}

}
