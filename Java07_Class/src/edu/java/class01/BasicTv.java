package edu.java.class01;

// 클래스(class)
// - 만들고자 하는 대상의 상태(속성) 정보들을 "멤버 변수(필드)"로 선언하고,
// 대상이 가져야 할 기능들을 "메소드"로 정의하는,
// 새로이 만드는 "데이터 타입"

// BasicTv라는 클래스는 기능을 직접 하는게 아닌 이 기능을 가져다가 사용을 해야한다.
// 
public class BasicTv {
	// TV가 가져야할 상태(속성, 성질) => 멤버 변수(필드, 프로퍼티) 
	boolean powerOn; // TV의 전원 상태(true : on, false : off)
	int channel = 1; // TV의 채널 정보. 1로 초기화
	int volume; // TV의 소리 정보. 0으로 초기화
	
	// TV가 가져야 할 기능 => 메소드
	
	// 전원(powerOn) on/off 기능
	public void turnOnOff() {
		if (powerOn == false) {
			powerOn = true;
			System.out.println("TV가 켜졌습니다.");
		} else {
			powerOn = false;
			System.out.println("TV가 꺼졌습니다.");
		}
	}
	
	// 채널 증가 기능 메소드
	public void channelUp() {
		// 이 메소드를 호출하면 channel 변수가 1씩 증가
		// 1, 2, 3, 4, 5, 1, 2, ... 순환 구조를 갖는다.
		channel ++;
		if (channel == 6) { 
			channel = 1;
		}
		System.out.println("channel Up : " + channel);
	}
	
	// 채널 감소 기능 메소드
	public void channelDown() {
		// 이 메소드를 호출하면 channel 변수가 1씩 감소
		// 5, 4, 3, 2, 1, 5, 4, ... 순환 구조를 갖는다.
		channel --;
		if (channel == 0) { 
			channel = 5;
		}
		System.out.println("channel Down : " + channel);
	}
	
	
	// 채널 감소 기능 메소드
	
	public void displayInfo( ) {
		System.out.println("--- TV 현재 상태 ---");
		System.out.println("전원 : " + powerOn);
		System.out.println("채널 : " + channel);
		System.out.println("볼륨 : " + volume);
		
	}
	
	// 소리 증가 기능 메소드(소리 최대 4)
	public void volumeUp() {
		volume++;
		if(volume >= 4) {
			volume = 4;
		}
//		if(volume < 4) { // 4보다 작다라고 해놔도 if 조건이 실행된후 ++;가 실행되므로 4가된다.
//			volume++;
//		} // 강사님 코드 더 짧다.
		
		System.out.println("volum Up : " + volume);
	}
	
	
	// 소리 감소 기능 메소드(소리 최소 0)
	public void volumeDown() { 
		volume--;
		if(volume <= 0 ) {
			volume = 0;
		}
//		if(volume > 0) {
//			volume--;
//		} // 강사님 코드
		
		System.out.println("volume Down : " + volume);
	}
	
	
	
	
	
	
} // end BasicTv() 
