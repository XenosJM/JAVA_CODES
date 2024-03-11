package edu.java.homework;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.java.file04.ContactVO;

//2. [이름]_HW6.java 클래스
//- 이름, 수학, 영어 데이터 Scanner로 입력 받아서 파일에 저장
//  (데이터 5개 이상)
//- 저장된 데이터를 출력
//- 예시)
//~ 데이터 입력 및 저장하는 코드 작성
//-----------------------------------------
//~ 데이터 불러와서 출력하는 코드 작성


public class HW062 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
			out = new FileOutputStream("temp/StuInfo.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			List<Student2> list = new ArrayList<>();
			for(int i = 0; i < 5; i++) {
				System.out.println("학생의 정보를 입력해주세요.");
				System.out.println("학생 이름>");
				String name = sc.next();
				System.out.println("수학 점수>");
				int math = sc.nextInt();
				System.out.println("영어 점수>");
				int eng = sc.nextInt();
				
				Student2 stu = new Student2(name, math, eng);
				stu.displayInfo();
				list.add(stu);							
			}
			oout.writeObject(list);
			System.out.println("데이터 저장 완료");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end try-catch-finnal
		
		// ==========================================================
		
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("temp/StuInfo.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<Student2> list = (ArrayList<Student2>)oin.readObject();
			for(Student2 stu : list) {
				stu.displayInfo();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end try-catch-finally
	} // end main()
}// end HW062
