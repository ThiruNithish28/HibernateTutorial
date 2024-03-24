package many2manyMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many2manyMapping.dto.Student;

public class StudentDao {

	public EntityManager getManager() {
		return Persistence.createEntityManagerFactory("MappingDemo").createEntityManager();
	}
	public void updateStudent(int id , Student updateStudent) {
		EntityManager em = getManager();
		Student studentFind = em.find(Student.class, id);
		if(studentFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			// update id 
			updateStudent.setId(id);
			//update the old course list to the update one
			updateStudent.setCourseList(studentFind.getCourseList()); 
			em.merge(updateStudent);
			et.commit();
		}else {
			System.out.println("Soory! the id is not found");
		}
	}
	
	public void findStudent(int id) {
		EntityManager em = getManager();
		Student studentFind = em.find(Student.class, id);
		if(studentFind != null) {
			System.out.println(studentFind);
		}else {
			System.out.println("Sorry! the id is not found");
		}
	}
	
	public void deleteStudent(int id) {
		EntityManager em = getManager();
		Student studentFind = em.find(Student.class, id);
		if(studentFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(studentFind);
			et.commit();
		}else {
			System.out.println("Soory ! the id is not found");
		}
	}
}
