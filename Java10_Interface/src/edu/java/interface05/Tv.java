package edu.java.interface05;

public class Tv implements RemoteController{

	@Override
	public void turnON() {
		System.out.println("TV 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("TV 꺼짐");
	}

}
