package edu.java.string02;


public class StringMain02 {

	public static void main(String[] args) {
		// length() : 문자열의 길이를 리턴
		String str1 = "abc";
		String str2 = "Hello";
		System.out.println(str1.length()); // 문자열의 내용을 문자로 인식해서 센다.
		System.out.println(str2.length());
		
		System.out.println("--------------");
		// equals() : 문자열의 내용을 비교
		System.out.println(str1.equals(str2));
		
		System.out.println("--------------");
		// equalsIgnoreCase() : 대소문자 구분없이 비교
		String str3 = "hello";
		String str4 = "Hello";
		System.out.println(str3.equals(str4));
		System.out.println(str3.equalsIgnoreCase(str4));
		
		System.out.println("--------------");
		// charAt() " 문자열 중에서 해당 인덱스의 문자 하나를 리턴
		System.out.println(str3.charAt(1)); // 1번 인데스 문자 리턴
		
		System.out.println("--------------");
		// indexOf() : 해당 문자 또는 문자열이 처음으로 등장하는 인덱스를 리턴
		//				해당 문자 또는 문자열이 없으면 -1을 리턴
		// lastIndexOf() : 문자 또는 문자열이 가장 마지막으로 등장하는 인덱스를 리턴
		String str5 = "Hello, world!";
		System.out.println(str5.indexOf("l"));
		System.out.println(str5.indexOf("world"));
		System.out.println(str5.lastIndexOf("l"));
		
		System.out.println("--------------");
		// startWith() : 해당 문자열로 시작하는지 아닌지 확인
		String str6 = "https://www.google.com";
		System.out.println(str6.startsWith("https"));
		
		System.out.println("---------------");
		// contains() : 해당 문자열이 포함하는지 아닌지
		System.out.println(str6.contains("google"));
		
		System.out.println("---------------");
		// split() : 문자열을 특정 기준(구분자)으로 나눠서 배열로 리턴
		String str7 = "2024.02.19";
		String[] result = str7.split("\\.");
		// 특수기호(.$()[]{}^?*+\\) 사용은 기호앞에 "\\"를 붙여주어야 한다.
		for(String x : result) {
			System.out.println(x);
		}
		
		String str8 = "C:\\Program Files\\test folder";
		// C, Program Files, test, folder 
		result = str8.split("\\\\| |:");
		for(String x : result) {
			System.out.println(x);
		}
		
		String str9 = "2024-02-19 11:30:42";
		// 퀴즈) 위 문자열을 "2024", "02", "19", "11", "30", "42"
		// 로 나누기
		// 월 데이터가 1월 ~ 6월이면 "상반기", 7월 ~ 12월이면 "하반기"
		// 가 출력되도록 코드 작성
		result = str9.split("-| |:");
		int month = Integer.parseInt(result[1]); // 문자열을 숫자로 변환
		System.out.println(month);
		if(month >= 1 && month <= 6) {
			System.out.println("상반기");
		} else {
			System.out.println("하반기");
		}
		
		System.out.println("---------------");
		// compareTo() : 해당 문자열과 비교해서 서로 다른 문자의 개수 리턴
		// compareToIgnoreCase() : 해당 문자열과 대소문자 구분없이
		//						비교 후 서로 다른 문자의 개수 리턴
		// compatrTo 종류는 잘 사용하지 않는다. 알아만 둘 것.
		
		String str10 = "abc";
		String str11 = "bbc";
		System.out.println(str10.compareTo("abc"));
		System.out.println(str10.compareTo("ab"));
		System.out.println(str10.compareTo("a"));
		System.out.println(str10.compareTo("b")); // 값이 -1인 이유는 같은자리 기준으로 -1이다르기때문
		System.out.println(str10.compareTo(str11));
		
		System.out.println("---------------");
		// toUpperCase() : 문자열을 대문자로 변경
		// toLowerCase() : 문자열을 소문자로 변경
		String str12 = "Hello, Java!";
		System.out.println(str12.toUpperCase());
		System.out.println(str12.toLowerCase());
		
		System.out.println("---------------");
		// substring(begin, end) : begin부터 end까지 문자열을 리턴
		// begin 인덱스는 포함, end 인덱스는 포함되지 않음
		System.out.println(str12.substring(0, 5)); // 0 <= index < 5
		
		int begin = str12.indexOf("J");
		int end = str12.length();
		System.out.println(str12.substring(begin, end));
		System.out.println(str12.substring(7, 12)); 
		// ㄴ 값이 정적(하드코딩). 동적일 경우 값이 달라지거나 오류가 남
		
		System.out.println("---------------");
		// concat() : 문자열을 이어주는 메소드
		System.out.println(str12.concat(str12));
		// + 와 기능 자체는 같으나 더 효율적
		// + 는 가독성이 좋지만 +가 사용 될때마다 공간을 만들기 때문에 비효율 적이다. (for문에서 치명적)
		
		System.out.println("---------------");
		System.out.println(str12.concat("World"));
		
		System.out.println("---------------");
		// replace(A, B) : A문자열을 B로 변경
		String str13 = str12.replace("Java", "C++");
		System.out.println(str13);
		
	} // end main()
		
	// 배열의 인덱스값을 랜덤으로 바꾸는 코드

//		public class ArrayShuffler {
//		    public void shuffleArray(int[] array) {
//		        Random rnd = new Random();
//		        for (int i = array.length - 1; i > 0; i--) {
//		            int index = rnd.nextInt(i + 1);
//		            // Swap array[i] and array[index]
//		            int temp = array[i];
//		            array[i] = array[index];
//		            array[index] = temp;
//		        }
//		    }
//
//		    public void main(String[] args) {
//		        int[] arr = {1, 2, 3, 4, 5};
//		        shuffleArray(arr);
//		        System.out.println("Shuffled array:");
//		        for (int num : arr) {
//		            System.out.print(num + " ");
//		        }
//		    }
//		}
		
		

} // end StringMain02




