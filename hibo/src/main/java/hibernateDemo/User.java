package hibernateDemo;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class User{
	
	// how to auto generate the id ?
	/* 		with the help of one annotation 
	  @GeneratedValue(strategy =GenerationType.Identity)
	  Feature:
	  	-> it will work only on number data type
	  	-> it will start from number 1
	  	-> for every new entries the number is going to increase by 1
	  	
	 	
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String address;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + "]";
	}
	
}
