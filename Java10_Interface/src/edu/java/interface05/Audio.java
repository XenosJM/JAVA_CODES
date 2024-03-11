package edu.java.interface05;

public class Audio implements RemoteController{

	@Override
	public void turnON() {
		System.out.println("오디오 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오 꺼짐");
	}

}
