package edu.java.inherit08;

public class Employee {
	// 멤버 변수
	private String name;

	public Employee() {}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println("직원");
	}
	
	

} // end Employee
