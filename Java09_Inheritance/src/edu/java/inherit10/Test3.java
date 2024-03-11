package edu.java.inherit10;

import edu.java.inherit09.Test2;

public class Test3 extends Test2{
	
	@Override
	public void display() {
//		System.out.println("a = " + a); // private 값이기에 보이지 않음
//		System.out.println("b = " + b); // (package) 값이기에 다른 패키지에서 보이지 않음
		System.out.println("c = " + c); // protected 값이라 패키지가 달라도 볼수 있음
		System.out.println("d = " + d);
	}
	
	
}
