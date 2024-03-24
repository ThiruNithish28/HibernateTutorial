package many2manyMapping.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	private int Id;
	private String Name;
	private double Fee;
	
	public int getCourseId() {
		return Id;
	}
	public void setCourseId(int Id) {
		this.Id = Id;
	}
	public String getCourseName() {
		return Name;
	}
	public void setCourseName(String Name) {
		this.Name = Name;
	}
	public double getCourseFee() {
		return Fee;
	}
	public void setCourseFee(double Fee) {
		this.Fee = Fee;
	}

}
