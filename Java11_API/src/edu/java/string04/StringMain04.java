package edu.java.string04;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringMain04 {

	public static void main(String[] args) {
		System.out.println("정규표현식 연습");
		
		Scanner sc = new Scanner(System.in);
		
		String data = sc.next();
		
		String regExp = "(02|032|010)-\\d{3,4}-d{4}";
		
		// (02|032|010) : 02 또는 032 또는 010으로 시작
		// - : '-' 기호 확인
		// \d{3, 4} : 3 ~ 4자리의 숫자
		// \d{4} : 4자리의 숫자
		
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상적인 전화번호 입니다.");
		} else {
			System.out.println("잘못된 전화번호입니다.");
		}
		
		data = sc.next();
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		// \w+ : 한 개 이상의 알파벳 또는 숫자
		// @ : @가 존재하는지
		// \w+ : 한 개 이상의 알파벳 또는 숫자
		// \. : .가 존재하는지
		// \w+ : 한 개 이상의 알파벳 또는 숫자
		// (\.\w+)? : \.\w+가 없거나 한 번 더 올 수 있음
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("정상적인 이메일입니다.");
		} else {
			System.out.println("잘못된 이메일입니다.");
		}
		
		
		
	} // end main()

} // end StringMain04





