package edu.java.array07;

public class ArrayMain07 {

	public static void main(String[] args) {
		System.err.println("배열 연습3");
		String test = "문자열입니다.";  // 문자열은 char의 배열인 셈이다. String도 인덱스를 가지고 있다.
		System.out.println(test);
		System.out.println(test.length()); // test. Ctrl + Space bar시 이용가능만 많은 메서드가 뜬다.
		
		for(int i = 0; i < test.length(); i++) { 
			System.out.println(test.charAt(i));
			if(test.charAt(i) == '열') {
				break;
			}
		}
		
		// 문자열 배열 선언
		String[] subjects = {"국어", "영어", "수학", "프로그래밍"};
		
		// 모든 과목들의 문자열 길이를 출력
		// 각 문자열에 "어"라는 글자가 포함되어 있는 경우만
		// 문자열 길이를 출력하쇼.
		for(int i = 0; i < subjects.length; i++) { // .length에 ()가 없다. (배열의 배열이기에 없다.)
			if(subjects[i].contains("어")) { // 문자열 배열 안에 "어"가 포함 되있는가? 를 물어보는 메서드
				System.out.println("과목명 : " + subjects[i]);
				System.out.println("문자열 길이 : " + subjects[i].length()); // 여기는 length에는 ()존재 (배열이 아닌 문자열의 배열)				
			}
		}
		
		for(String str : subjects) {
			if(str.equals("프로그래밍")) { // 문자열 비교는 equals를 쓴다.
				System.out.println("재밌다!");
				System.out.println(str.length());
			}
		}
		

	} // end main()

} // end ArrayMain07




