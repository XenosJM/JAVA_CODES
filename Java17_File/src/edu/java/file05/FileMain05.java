package edu.java.file05;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import edu.java.file04.ContactVO;

// 프로그램 <=== ObjectInputStream <=== FileInputStream <=== 파일(HDD)

public class FileMain05 {

	public static void main(String[] args) {
		InputStream in = null;
		ObjectInputStream oin = null;

		try {
			in = new FileInputStream("temp/member.txt");
			oin = new ObjectInputStream(in);
			while (true) {
				try {
					ContactVO m = (ContactVO) oin.readObject();
					// MemberVO
					System.out.println(m);
				} catch (EOFException e) {
					break; // EOFException 발생시 break;
				}
			}			
		} catch (Exception e) {
			System.out.println("예외 : " + e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} // end main()

} // end FileMain05
