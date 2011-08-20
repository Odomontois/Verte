package odo.verte.bean;

import java.util.List;

public class User {	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", otherNames="
				+ otherNames + "]";
	}
	private String name;
	private Integer age;
	private List<String> otherNames;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public List<String> getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(List<String> otherNames) {
		this.otherNames = otherNames;
	}
}
