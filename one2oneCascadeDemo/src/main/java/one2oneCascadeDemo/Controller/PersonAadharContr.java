package one2oneCascadeDemo.Controller;

import one2oneCascadeDemo.dao.PersonDao;
import one2oneCascadeDemo.dto.AadharCard;
import one2oneCascadeDemo.dto.Person;

public class PersonAadharContr {

	public static void main(String[] args) {
		Person person = new Person();
		person.setId(1);
		person.setName("Mohan");
		person.setAddress("Trichy");
		
		AadharCard aadharcard = new AadharCard();
		aadharcard.setId(101);
		aadharcard.setName("Mohan P");
		aadharcard.setAge(20);
		
		person.setAadharcard(aadharcard);
		
		/* Cascade : 
					cascade	is like a set of rules that define how changes to one entity affect related entites
			in a database relationship.
			
			Types: 
				1) Persist
				2) Merge
				3) Remove
				4) Detach
				5) Refresh
				6) All
			
		*/
		
		PersonDao dao = new PersonDao();
		dao.savePerson(person); 
		// Note:
		/* 		  when we use cascade " we don't need certain DAO for NON-OWNING side " 
		    ie; we eliminated the DAO of non owning side
		    
		    That why i can't create any DAO for AadharCard 
		    
		   * Without Cascade :
		    	 insert into Person (aadharcard_id, address, name, id) values (?, ?, ?, ?)
		    	
		   * With Cascade :
		    	
				 insert into AadharCard (age, name, id) values (?, ?, ?)
				 insert into Person (aadharcard_id, address, name, id) values (?, ?, ?, ?)

		
		*/
	}
}
