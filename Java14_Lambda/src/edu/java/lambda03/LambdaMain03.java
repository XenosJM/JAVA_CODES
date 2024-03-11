package edu.java.lambda03;

@FunctionalInterface
interface Test1 {
	public abstract int findMax(int x, int y);
} // end Test1

public class LambdaMain03 {

	public static void main(String[] args) {
		Test1 test1 = (x, y) -> (x > y) ? x : y;
		System.out.println("최대값 : " + test1.findMax(10, 5));
		
		
	} // end main()

} // end LambdaMain03




