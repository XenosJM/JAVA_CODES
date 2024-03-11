package edu.java.array05;

public class ArrayMain05 {

	public static void main(String[] args) {
		System.out.println("배열 연습1");
		
		// char 26개를 저장할 수 있는 배열 선언
		char[] alphas = new char[26];
		
		// for문을 사용하여 배열에 'a' ~ 'z'까지 저장
		for(char ch = 'a'; ch <= 'z' ; ch++) {
			alphas[ch-'a'] = ch; // 'a' - 'a' = 0, 'b' - 'a' = 1  == ch - 'a'
		}
		// 위와 아래는 같은 코드
		for(int i = 0; i < alphas.length; i++) {
			alphas[i] = (char) ('a' + i);
		}
		
		
		for(char ch : alphas) {
			System.out.print(ch + " ");
		}

	} // end main()

} // end ArrayMain05
