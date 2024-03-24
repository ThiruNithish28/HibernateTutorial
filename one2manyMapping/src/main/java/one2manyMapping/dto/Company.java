package one2manyMapping.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	@Id
	private int id;
	private String name;
	private String gst;
	@OneToMany
	private List<Employee> employes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
	}
	public List<Employee> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employee> employes) {
		this.employes = employes;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", gst=" + gst + ", employes=" + employes + "]";
	}
}
