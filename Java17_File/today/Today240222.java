package today;

public class Today240222 {
	
//	오늘수업 내용
	/*
	 *  쓰레드 걸러!
	 *  파일부분 복습은 4 5 6
	 */
	// Thread
	
	/* 자바는 다중 상속을 허용하지 않기 때문에
	 * 다른 클래스를 이미 상속받고 있는 경우에는 Thread 클래스를 상속받을 수 없음
	 * Runnable 인터페이스를 구현하여 Thread를 생성할 수 있는 방법을 제공
	 * 
	 * 자바에서 쓰레드를 생성하고 사용하는 방법2 : 
	 * 1. Runnable 인터페이스를 구현하는 클래스 정의(implements Runnable)
	 * 2. 정의한 클래스에서 run() 메소드를 override
	 * -> 쓰레드가 해야 할 기능 구현
	 * 3. 정의한 클래스(Runnable 구현 클래스)의 인스턴스 생성
	 * 4. Runnable 인스턴스를 매개변수로 해서 Thread 인스턴스를 생성
	 * 5. Thread 인스턴스에서 start() 메소드를 호출 -> run() 자동 호출
	 */
	
	// File
	
	/* 프로그램 <=== InputStream <=== 입력장치(키보드, 마우스, 파일, ...)
	 * 프로그램 ===> OutputStream ===> 출력장치(모니터, 프린터, 파일, ...)
	 *
	 * in : InputStream 클래스의 인스턴스
	 * 외부 입력장치(키보드, 마우스)로부터 데이터를읽어올 수 있는 통로
	 * 
	 * out : PrintStream 클래스의 인스턴스
	 * PrintStream은 OutStream 클래스의 하위 클래스
	 * 콘솔화면으로 데이터를 출력하는 통로
	 */
	/* 프로그램 <=== FileInputStream <== 파일
	 * FileInputStream 클래스의 read() 메소드를 사용하여 파일을 읽음
	 * 
	 * 프로그램 ===> FileOutputStream ==> 파일
	 * FileOutputStream 클래스의 write() 메소드를 사용하여 파일에 씀
	 */
	/* FileXXXStream : XXX부분의 여러 기능이름이 있는데 이 형식의 함수는
	 * 모두 해당 파일 입출력 객체. 통로 역할을 한다.
	 */
	/* read() : 파일에서 1바이트씩 데이터를 읽어옴, 기본형태
	 * ㄴ 파일 끝에 도달했을 때 -1을 리턴
	 * 
	 * read(byte[] b) :
	 * 파일에서 읽은 데이터를 매개변수 배열 b에 저장
	 * 실제로 읽은 바이트 수를 리턴, 파일 끝에서는 -1을 리턴
	 * 
	 * 그릇의 크기를 바꿀수 있다.
	 * byte[] buffer = new byte[1024 * 1024];
     *
	 * write() : 1바이트씩 파일에 씀
	 * write(byte[] b) :
	 * - 매개변수 배열 b의 내용을 한 번에 파일에 씀
	 * 
	 * 다만 byte[]의 크기는 판단하에 적절한 크기로 써야한다.
	 * 쓰거나, 읽어올 파일의 크기에 비해 너무 작거나 크면 
	 * 수행속도가 터무니없이 느려지기 때문에 적절하게 그릇의
	 * 크기를 정해야 한다.
	 */		
	/* 1. 일반적인 try-catch-finally 구문
	 * try {
	 * 		(실행문)
	 * } catch (Exception e) {
	 * 		(예외처리)
	 * } finally {
	 * 		(항상 실행할 코드들) // 리소스 삭제
	 * )
	 *   2. try-with-resource 구문 : Java 7버전부터 제공
	 *  - try() 안에서 생성된 리소스들의 해제 코드(close();)를 자동으로 호출해줌
	 * try(리소스 생성) {
	 *    (실행문)
	 * } catch (Exception e) {
	 *    (예외 처리)
	 * }
	 * ㄴ 다만 2번형식은 코드작성시는 편하지만. 가독성면에서는 안좋기 때문에
	 *  익숙하지 않거나 다른사람을 생각하면 1번이 좋다. 
	 */
	// 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일(HDD)
	// ㄴ 쓰기    		ㄴ 중간에 패키징하는 역할
	
	// 열린 터미널(스캐너 sc 등).close();
	// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만
	// 해제하면, 그 리소스(oout)가 사용하고 있는 다른
	// 리소스(out)들도 순차적으로 해제된다.
	
	// 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일(HDD)
	// ㄴ 읽어오기
	
	/* 프로그램 ===> ObjectOutputStream ===>
	 * BufferedOutputStream ===> FileOutputStream ===> 파일(HDD)
	 * ㄴ 중간에서 버퍼 역할을 수행 - 옛날 영상볼때 많이 본 버퍼링과 비슷한 기능
	 */
			
} // end Today240222
