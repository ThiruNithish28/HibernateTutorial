package one2manyMapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2manyMapping.dto.Company;
import one2manyMapping.dto.Employee;

public class EmployeeDao {

	public void saveEmploye(int companyId,Employee employe) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Company companyFind = em.find(Company.class,companyId);
		if(companyFind != null) {
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			// save the employee
			em.persist(employe);
			// update employee in company
			List<Employee> employeList = companyFind.getEmployes();
			employeList.add(employe);
			companyFind.setEmployes(employeList);
			
			et.commit();
		}else {
//			company is not present
			System.out.println("Sorry CompanyId is not present");
		}
	}
	
	public void updateEmployee(int id , Employee updateEmployee) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Employee employeeFind = em.find(Employee.class, id);
		
		if(employeeFind != null) {
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			updateEmployee.setId(id);
			em.merge(updateEmployee);
			
			et.commit();
		}else {
			System.out.println("Sorry Id is not present");
		}
	}
	
	
	// 
	/*It little bit differ from one 2one mapping where in one2one we cant delete the non owning side 
	before delete the owning side  
			but here we can delete the non owning side
	*/
	public void delete(int employeeId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Employee employeeFind = em.find(Employee.class, employeeId);
		if(employeeFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			em.remove(employeeFind);
			
			et.commit();
		}
	}
}
