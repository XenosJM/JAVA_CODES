package edu.java.homework;

public class HW3 {

	public static void main(String[] args) {
		MyCircle circ1 = new MyCircle();
		circ1.radius = 5;
		System.out.println("반지름 : " + circ1.radius);
		System.out.println("넓이 : " + circ1.calcArea());
		
		System.out.println("=========================");
		
		MyCircle circ2 = new MyCircle(4);
		System.out.println("반지름 : " + circ2.radius);
		System.out.println("넓이 : " + circ2.calcArea());		

	} // end main

} // end HW3
