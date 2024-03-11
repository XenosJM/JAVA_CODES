package edu.java.array09;

public class ArrayMain09 {

	public static void main(String[] args) {
		System.out.println();
		String[] avengers = {"아이언맨", "토르", " 헐크", "캡틴"}; // string은 문자열이라는 문자의 배열의 배열이므로 2차원으로 볼수있
		String[] villain = {"타노스", "하이드라", "레드스컬"}; 
		String[][] characters = { // 그러므로 두 문자열 배열을 묶으면 이 배열은 2차원이면서 3차원 배열로 볼수있다. 이걸 계층구조라고 한다.
				avengers,
				villain
		};
		
		// 모든 문자열 출력
		// 2차원 문자열 배열 characters에서 1차원 배열 group을 순회하고, 그 안의 문자열들을 출력합니다.
		// 2차원 -> 1차원 -> 문자열
		for (String[] group : characters) { 
		    for (String name : group) {
		        System.out.print(name + " "); // 문자열과 공백을 출력합니다.
		    }
		    System.out.println(); // 줄 바꿈을 출력하여 다음 그룹을 출력합니다.
		}

		// '이' 문자의 개수 세기
		int c = 0; // '이' 문자의 개수를 저장할 변수를 초기화합니다.
		for (String[] group : characters) { 
		    for (String name : group) {
		        for (int i = 0; i < name.length(); i++) { // 각 문자열에 대해 문자를 하나씩 순회합니다.
		            if (name.charAt(i) == '이') { // 현재 문자가 '이'인지 확인합니다.
		                c++; // '이' 문자를 발견하면 개수를 증가시킵니다.
		            }
		        }
		    }
		}
		System.out.println(c);
	} // end main()
	
} // end ArrayMain09





