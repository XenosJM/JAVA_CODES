package edu.java.programmers;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j <n; j++) {
        		if(i == 0 || j == 0 || i == n-1 || j==n-1 || (i + j)/ 3 == 2) {
        			System.out.print("*");
        		} else {
        			System.out.print(" ");
        		}
        	}
        	System.out.println();
        }
  
        
        
    } // end main()
} // end Solution
        
        
        
        
        
        
        // ============================================
        
//        String str = sc.next(); // 사용자로부터 문자열 입력 받기
//        int length = str.length(); // 문자열의 길이를 구함
//        
//        // 문자열의 각 문자를 확인하면서 대소문자 변환
//        for (int i = 0; i < length; i++) {
//            char ch = str.charAt(i); // 문자열의 각 자리의 문자를 가져옴
//            if ('a' <= ch && ch <= 'z') { // 소문자인 경우
//                System.out.print((char) (ch - 32)); // 소문자를 대문자로 변환하여 출력
//            } else if ('A' <= ch && ch <= 'Z') { // 대문자인 경우
//                System.out.print((char) (ch + 32)); // 대문자를 소문자로 변환하여 출력
//            }
//        }