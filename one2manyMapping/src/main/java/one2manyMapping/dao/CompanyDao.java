package one2manyMapping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import one2manyMapping.dto.Company;
import one2manyMapping.dto.Employee;
public class CompanyDao {
	public void saveCompany(Company company) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		// save the company
		em.persist(company);
		
		et.commit();
	}
	
	public void updateCompany(int companyId , Company updateCompany) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Company companyFind = em.find(Company.class, companyId);
		
		if(companyFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			//set Id
			updateCompany.setId(companyId);
			// set employee from the old data
			updateCompany.setEmployes(companyFind.getEmployes());  
			em.merge(updateCompany);
			
			et.commit();
		}
		else {
			System.out.println("Id is not present");
		}
	}
	
	public void findCompany(int companyId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Company companyFind = em.find(Company.class, companyId);
		if(companyFind != null) {
			// print company
			System.out.println(companyFind);
		}else {
			System.out.println("Sorry ! id is not there in DB");
		}
	}
	
	public void delete(int companyId) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MappingDemo");
		EntityManager em = emf.createEntityManager();
		
		Company companyFind = em.find(Company.class, companyId);
		if(companyFind != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			em.remove(companyFind);
			
			et.commit();
		}
	}
}
