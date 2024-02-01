package edu.java.programmers;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        String str = sc.next(); // 사용자로부터 문자열 입력 받기
        int length = str.length(); // 문자열의 길이를 구함
        
        // 문자열의 각 문자를 확인하면서 대소문자 변환
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i); // 문자열의 각 자리의 문자를 가져옴
            if ('a' <= ch && ch <= 'z') { // 소문자인 경우
                System.out.print((char) (ch - 32)); // 소문자를 대문자로 변환하여 출력
            } else if ('A' <= ch && ch <= 'Z') { // 대문자인 경우
                System.out.print((char) (ch + 32)); // 대문자를 소문자로 변환하여 출력
            }
        }
    } // end main()

} // end Solution