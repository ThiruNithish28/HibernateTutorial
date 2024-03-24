package many2manyMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many2manyMapping.dto.Course;

public class CourseDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("MappingDemo").createEntityManager();
	}
	
	public void updateCourse(int id , Course updateCourse) {
		EntityManager em = getEntityManager();
		Course courseFind = em.find(Course.class, id);
		if(courseFind!=null) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		updateCourse.setCourseId(id);
		em.merge(updateCourse);
		et.commit();
		}
	}
	
	public void findCourse(int id) {
		EntityManager em = getEntityManager();
		Course courseFind = em.find(Course.class, id);
		if(courseFind!=null) {
			System.out.println(courseFind);
		}else {
			System.out.println("sorry ! id is not Found");
		}
	}
	
	//DELETE : 
	/*
	  		"We can't able to delete the non-Owning side First" , If we try it shows an ERROR
	  	ie; Before deleting the owning side(student) we CAN'T ABLE to Delete the Non- Owning side (course).
	  	So we first delete the owning side entity then only we can delete the non owning side entity which are share
	  	the relationship with owning side	 
	 */
	public void delete(int id) {
		EntityManager em = getEntityManager();
		Course courseFind = em.find(Course.class, id);
		if(courseFind!=null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(courseFind);
			et.commit();
		}else {
			System.out.println("Sorry ! the id is not found");
		}
	}
}
