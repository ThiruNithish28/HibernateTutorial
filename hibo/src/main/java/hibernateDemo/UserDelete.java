package hibernateDemo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDelete {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		User userToDelete = em.find(User.class, 10); // where find() we dont need to EntityTransaction
		if(userToDelete != null) {
			et.begin();
			/* If you want to delete the data in table (DB) then we use em.remove(obj) for this 
			first we have to find the data which want to delete from DB and then pass as agrument to remove()
			*/
			em.remove(userToDelete);
			et.commit();
		}else {
			System.out.println("Sorry ! enter userId is not prsent in DB");
		}

	}

}
