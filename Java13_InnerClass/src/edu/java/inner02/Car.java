package edu.java.inner02;

/* 멤버 내부 클래스(member inner class)를 사용하는 경우
 *  상속 관계로 묶을 수 없지만,
 *  A라는 객체가 생성된 이후에만 존재할 수 있는 B라는 객체가 있다면
 *  B를 A의 내부 클래스로 정의
 *  (예) 자동차 - 타이어, PC - CPU/RAM 등
 */
public class Car {
	private String name;

	public Car(String name) {
		this.name = name;
	}

	class Tire {
		private int size;

		// 멤버 내부 클래스(member inner class)의 생성자
		public Tire(int size) {
			this.size = size;
		}

		public void display() {
			System.out.println("--- 자동차 정보 ---");
			System.out.println("자동차 이름 : " + name);
			System.out.println("타이어 크키 : " + size);
		}
	}
} // end Car
