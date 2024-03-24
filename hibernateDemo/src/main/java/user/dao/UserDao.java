package user.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import user.dto.User;

public class UserDao {
	
	
	public void saveUser(User user) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(user);
		et.commit();
	}
	
	public void updateUser(int id, User userToUpdate) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
		EntityManager em = emf.createEntityManager();
		
		User userFind = em.find(User.class, id);
		
		if(userFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			userToUpdate.setId(id);
			em.merge(userToUpdate);
			et.commit();
		}
		else {
			System.out.println("Sorry! user id is not found in DB");
		}
		
	}
	
//	Find method
	
	public void findUser(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
		EntityManager em = emf.createEntityManager();
		
		User requiredUser = em.find(User.class, id);
		
		if(requiredUser != null)
			System.out.println(requiredUser);
		else
			System.out.println("Sorry ! enter user id is not found");
	}
	
//	delete method
	
	public void deleteUser(int id) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
		EntityManager em = emf.createEntityManager();
		
		User userToDelete = em.find(User.class, id);
		
		if(userToDelete != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(userToDelete);
			et.commit();
		}else {
			System.out.println("Sorry ! user id is not Found");
		}
			
	}
	
//	
	
	public void showAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateDemo");
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select u from User u");
		List<User> userList = query.getResultList();
		for(User user : userList) {
			System.out.println(user);
		}
		System.out.println();
	}
	
}
