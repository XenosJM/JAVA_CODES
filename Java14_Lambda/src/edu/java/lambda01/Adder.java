package edu.java.lambda01;

// FunctionalInterface : 추상 메소드가 하나뿐인 메소드
// 람다(lambda) 표현식은 funtion interface만 사용 가능 
@FunctionalInterface // 어노테이션
public interface Adder {
	public abstract double add(double x, double y);
}
