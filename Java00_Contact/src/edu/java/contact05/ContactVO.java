package edu.java.contact05;

import java.io.Serializable;

public class ContactVO implements Serializable{
	private String name;
	private String phone;
	private String email;
	private String index;

	
	
	public ContactVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ContactVO(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "ContactVO [이름=" + name + ", 전화번호=" + phone + ", 이메일=" + email + "]";
	}



	 public String[] toStringArray() {
        String[] array = new String[4];
        array[0] = index;
        array[1] = name;
        array[2] = phone;
        array[3] = email;
        return array;
    }
	
}
