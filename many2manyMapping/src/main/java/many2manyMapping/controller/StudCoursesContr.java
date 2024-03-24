package many2manyMapping.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many2manyMapping.dao.CourseDao;
import many2manyMapping.dao.StudentDao;
import many2manyMapping.dto.Course;
import many2manyMapping.dto.Student;

public class StudCoursesContr {
	

	public static void main(String[] args) {
		
//		Course course1 = new Course();
//		course1.setCourseId(1);
//		course1.setCourseName("Java");
//		course1.setCourseFee(300.00);
//		
//		Course course2 = new Course();
//		course2.setCourseId(2);
//		course2.setCourseName("Advance Java");
//		course2.setCourseFee(600.00);
//		
//		Course course3 = new Course();
//		course3.setCourseId(3);
//		course3.setCourseName("SQL");
//		course3.setCourseFee(600.00);
//		
//		Student std1 = new Student();
//		std1.setId(1);
//		std1.setName("Thiru");
//		std1.setAddress("Thanjavur");
//		List<Course> std1Course = new ArrayList<>();
//		std1Course.add(course1);
//		std1Course.add(course2);
//		std1.setCourseList(std1Course);
//		
//		Student std2 = new Student();
//		std2.setId(2);
//		std2.setName("Thiru");
//		std2.setAddress("Thanjavur");
//		List<Course> std2Course = new ArrayList<>();
//		std2Course.add(course1);
//		std2Course.add(course3);
//		std2.setCourseList(std2Course);
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		em.persist(course1);
//		em.persist(course2);
//		em.persist(course3);
//		em.persist(std1);
//		em.persist(std2);
//		et.commit();
//		 
		
//		StudentDao sDAO = new StudentDao();
//		Student updateStudent = new Student();
//		updateStudent.setName("Mohan");
//		updateStudent.setAddress("Trichy");
//		sDAO.updateStudent(2, updateStudent);
//	Delete:	
//		CourseDao cDAO = new CourseDao();
//		cDAO.delete(1); // we can't delete the non owning side First
		
		// Find
		StudentDao SDao = new StudentDao();
		SDao.findStudent(1);
	}

}
