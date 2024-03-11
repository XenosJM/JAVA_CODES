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

public class 박정민_HW6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream("temp/StudentInfo.txt");
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			
			List<Student> list = new ArrayList<>();
			for(int i = 0; i < 5; i++) { // 5개 이상의 데이터 입력을 해야하니 5개까지로 일단 설정
				System.out.println("학생의 정보를 입력하세요>");
				System.out.println("학생 이름>");
				String name = sc.next();
				System.out.println("수학 점수>");
				int math = sc.nextInt();
				System.out.println("영어 점수>");
				int eng = sc.nextInt();				
				Student stu = new Student(name, math, eng);
				list.add(stu);
				stu.displayInfo();
			}
			oout.writeObject(list);
			System.out.println("학생 정보 입력 완료");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end try-catch-finally
		
		// ==================================================
		
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("temp/StudentInfo.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<Student> list = (ArrayList<Student>)oin.readObject();
			for(Student stu : list) {
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

	
} // 박정민_HW6







