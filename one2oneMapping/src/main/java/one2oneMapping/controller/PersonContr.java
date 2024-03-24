package one2oneMapping.controller;


import one2oneMapping.dao.PersonDao;
import one2oneMapping.dto.Person;
import one2oneMapping.dto.AadharCard;
import one2oneMapping.dao.AadharCardDao;

public class PersonContr {
	public static void main(String[] args) {
//		Person person = new Person();
//		person.setId(1);
//		person.setName("Thiru");
//		person.setAddress("Thanjavur");
//		
//		PersonDao dao= new PersonDao();
//		dao.savePerson(person);
		
//		AadharCard aadharcard = new AadharCard();
//		aadharcard.setId(100);
//		aadharcard.setAge(20);
//		aadharcard.setName("Thiru");
//		AadharCardDao aadharDAO = new AadharCardDao();
//		aadharDAO.saveAadharCard(1, aadharcard);
//		
//     	AadharCardDao aadharDAO = new AadharCardDao();
//		aadharDAO.deleteAadhar(100);
		
		PersonDao dao = new PersonDao();
		dao.findPerson(1);
				
	}

}
