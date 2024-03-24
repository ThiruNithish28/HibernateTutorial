package one2manyMapping.controller;

import one2manyMapping.dao.CompanyDao;
import one2manyMapping.dao.EmployeeDao;
import one2manyMapping.dto.Company;
import one2manyMapping.dto.Employee;

public class EmployeeCompanyContr {
	public static void main(String[] args) {
	
//		Company company = new Company();
//		company.setId(1);
//		company.setName("tcs");
//		company.setGst("t@3rn");
//		
//		CompanyDao dao = new CompanyDao();
//		dao.saveCompany(company);
		
//		Employee empolyee = new Employee();
//		empolyee.setId(101);
//		empolyee.setName("Thiru");
//		empolyee.setAddress("Thanjavur");
//		
//		empolyee.setId(102);
//		empolyee.setName("Mohan");
//		empolyee.setAddress("Trichy");
//		
//		EmployeeDao dao = new EmployeeDao(); 
//		dao.saveEmploye(1, empolyee);

// UPDATE		
//		Company company = new Company();
//		company.setName("TCS");
//		company.setGst("T@3R");
//		
//		CompanyDao companyDAO = new CompanyDao();
//		companyDAO.updateCompany(1, company);
		
// DELETE
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.delete(102);
//		employeeDao.delete(101);
//		
//		CompanyDao dao = new CompanyDao();
//		dao.delete(1);
		
		// Find
		CompanyDao Cdao = new CompanyDao();
		Cdao.findCompany(1);
	}
}
