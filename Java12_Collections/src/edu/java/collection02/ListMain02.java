package edu.java.collection02;

import java.util.ArrayList;

class Student {
	// 멤버 변수
	private int stuNo;
	private String name;
	
	public Student() {}
	
	public Student(int stuNo, String name) {
		super();
		this.stuNo = stuNo;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + "]";
	}
	
} // end Student

public class ListMain02 {

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>(); // 생성된 인스턴스의 리턴타입은 생략 가능
		list1.add(100);
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("test");
		
		// Student 타입을지정할 수 있는 arrayList 인스턴스 생성
		ArrayList<Student> list3 = new ArrayList<>();
		
		list3.add(new Student(1, "kim")); // 이쪽이 조금 더 효율적
		// add안에 선언한 타입의 값을 넣는데 이 때 이미 만들어진 값을 넣거나 인스턴스를 생성해서 넣을수있다.
		Student stu1 = new Student(2, "park");
		list3.add(stu1);
		
		for(int i = 0; i < list3.size(); i++) {
			System.out.println(list3.get(i));
		}
		
	} // end main()

} // end ListMain02





