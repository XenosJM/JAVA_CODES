package edu.java.homework;

import java.util.Scanner;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		String password = sc.next();
		
		boolean result = memberService.login(id, password);
		if(result) {
			System.out.println("로그인 되었습니다.");
			memberService.logout(id);
		} else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
		
//	public static void main(String[] args) {
//		MemberService MS = new MemberService();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("이름을 입력해 주세요");
//		String i = sc.next();
//		System.out.println("비밀번호를 입력해 주세요");
//		String p = sc.next();
//		
//		MS.id = i;
//		MS.passWord = p;
//		
//		if(MS.login() == true) {
//			System.out.println("로그인 되었습니다.");
//		} else {
//			System.out.println("로그인 하지 못했습니다.");
//		}
//		
//		MS.logout();
//		
		
		
		

	} // end main()

} // end MemberServiceMain
