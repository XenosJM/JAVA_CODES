package edu.java.method02;

public class MethodMain02 {
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 합을 리턴
	// 메소드 이름 : add
	// 리턴타입 : int
	// 매개변수 : int x, int y
		
	public static int add(int x, int y) {
		int result = x + y;
		return result; // == return x + y; 상황에 따라 다르게... 
	} // end add()
	
	
	// 기능 : 두 개의 정수를 매개변수로 전달받아서, 두 정수의 차를 리턴
	// 메소드 이름 : sub
	// 리턴타입 : int
	// 매개변수 : int x, int y
		
	public static int sub(int x, int y) {
		return x - y;
//		return Math.abs(x - y); // 절대값
	} // end sub()
	
	// 기능 : 두 개의 실수를 매개변수로 전달받아서, 두 실수의 곱을 리턴
	// 메소드 이름 : mul
	// 리턴타입 : double
	// 매개변수 : double x, double y
	
	public static double mul(double x, double y) { 
		return x * y;
	} // end mul()
	
	// 기능 : 두 개의 실수를 매개변수로 전달받아서 x를 y로 나눈 값을 리턴
	// 메소드 이름 : div
	// 리턴타입 : double
	// 매개변수 : double x, double y
	
	public static double div(double x, double y) {
		return x / y;
	}
	
	public static void main(String[] args) {
	    // 두 숫자를 더한 결과를 변수에 저장하고, 그 값을 출력합니다.
	    int result = add(10, 20);
	    System.out.println(result);
	    
	    // 두 숫자를 더한 결과를 직접 출력합니다.
	    System.out.println(add(10, 20));  
	    
	    // 두 숫자를 빼고 그 결과를 변수에 저장하고, 그 값을 출력합니다.
	    result = sub(20, 10);
	    System.out.println(result);
	    
	    // 두 숫자를 곱한 결과를 변수에 저장하고, 그 값을 출력합니다.
	    double m = mul(1.5, 2.0);
	    System.out.println("m = " + m);
	    
	    // 두 숫자를 나눈 결과를 변수에 저장하고, 그 값을 출력합니다.
	    // 정수를 정수로 나누어서 결과를 반환하므로 자동 형 변환 가능성을 염두합니다.
	    double d = div(3, 2);
	    System.out.println("d  = " + d);
	} // end main()

} // end MethodMain02 ()
