package edu.java.access10;

// 싱글톤 패턴 : 생성자가 여러 차례 호출되더라도실제로 생성되는 객체는 하나이고
//			최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴
public class AccessMain10 {
	
	public static void main(String[] args) {
		PublicToilet toilet1 = PublicToilet.getInstance();
		toilet1.setLocation("캠핑장");
		System.out.println(toilet1);
		System.out.println(toilet1.getLocation());
		
		System.out.println("-----------");
		PublicToilet toilet2 = PublicToilet.getInstance();
		System.out.println(toilet2);
		System.out.println(toilet2.getLocation());
		
		toilet2.setLocation("공연장");
		System.out.println(toilet1.getLocation());
		System.out.println(toilet2.getLocation());
		
		
	} // end main()
	
} // end AccessMain10








