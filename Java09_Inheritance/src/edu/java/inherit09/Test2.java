package edu.java.inherit09;

public class Test2 extends Test1 {
	@Override
	public void display() {
//		System.out.println("a = " + a); // a값이 private이기 때문에 에러가 난다.
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
	}
} // end Test2
