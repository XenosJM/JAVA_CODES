package edu.java.file04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

// 프로그램 ===> ObjectOutputStream ===> FileOutputStream ===> 파일(HDD)
//				ㄴ 중간에 패키징하는 역할
public class FileMain04 {

	public static void main(String[] args) {
		OutputStream out = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("temp/member.txt");
			oout = new ObjectOutputStream(out);
			
			ContactVO m1 = new ContactVO(1, "root1", "root123");			
			oout.writeObject(m1); // 다형성
			
			ContactVO m2 = new ContactVO(2, "root2", "root123");			
			oout.writeObject(m2); // 다형성
			
			ContactVO m3 = new ContactVO(3, "root3", "root123");			
			oout.writeObject(m3); // 다형성
			
			System.out.println("파일 저장 성공!");
			
		} catch (Exception e) {
			System.out.println("예외발생 : " + e.toString());
		} finally {
			try {
				// 리소스(oout)를 해제할 때는 최종적으로 생성된 리소스만
				// 해제하면, 그 리소스(oout)가 사용하고 있는 다른
				// 리소스(out)들도 순차적으로 해제된다.
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end try-catch-finally
		
		
	} // end main()

} // end FileMain04




