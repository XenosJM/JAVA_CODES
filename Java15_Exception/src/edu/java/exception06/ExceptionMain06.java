package edu.java.exception06;

public class ExceptionMain06 {

	public static void main(String[] args) {
		
	      try {
	          System.out.println("try 시작");
	          int result = 123 / 0;
	          int[] array = new int[10];
	          array[10] = 10;
	          System.out.println("try 끝");
	       } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
	          System.out.println("예외 : " + e.toString());
	       } catch (Exception e) {
	          System.out.println("예외 : " + e.toString());
	       }
		
		
		
	} // end main()

} // end ExceptionMain06
