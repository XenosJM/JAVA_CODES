package edu.java.string03;

/* String 클래스 : immutable 클래스(내용이 바뀌지 않는 클래스)
 * StringBuffer, StringBuilder : mutable 클래스(내용을 바꿀 수 있는 클래스)
 * 
 * StringBuffer : Java 1.0 버전부터 사용된 클래스
 * - 추가/삭제 속도가 느림
 * - Thread-safe : 쓰레드에 안전한 클래스
 * - 멀티쓰레드 환경에서 사용하기 적합
 * 
 * StringBuilder : Java 5.0 버전부터 사용된 클래스
 * - 추가/삭제 속도가 빠름 (Buffer보다 상대적인 빠름)	
 * - Thread-unsafe : 쓰레드에 안전하지 않은 클래스
 * - 싱글쓰레드 환경에서 사용하기 적합
 * 그 외 모든 기능이 동일(동일한 기능의 메소드들을 가지고 있음) - 핵심
 * 
 * 버퍼와 빌더는 선언한 그릇에 더하면서 변경하는거라면
 * concat()과 + 는 사용 할 때 마다 선언 해서 비효율 적이다.
 * 반복문이아니면 +사용, 반복문이면 버퍼나 빌더 사용
 */
public class StringMain03 {

	public static void main(String[] args) {
		// StringBuffer, StringBuilder 클래스
		StringBuffer buffer = new StringBuffer("abc");
//		StringBuffer buff = "abc"; // 컴파일 에러, 반드시 new로 선언해야함
		
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		System.out.println(buffer.hashCode());
		
		// append() : 문자열을 덧붙이는 메소드
		buffer.append("def").append("ghi");
		System.out.println(buffer);
		System.out.println(System.identityHashCode(buffer));
		System.out.println(buffer.hashCode());
		
		System.out.println("-----------------");
		String str = "abc";
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		
		str = str + "";
		System.out.println(str);
		System.out.println(System.identityHashCode(str));
		System.out.println(str.hashCode());
		
		
	} // end main()

} // end StringMain03




