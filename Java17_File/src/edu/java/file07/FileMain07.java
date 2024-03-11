package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import edu.java.file04.ContactVO;

public class FileMain07 {

	public static void main(String[] args) {
		System.out.println("파일에 저장된 ArrayList<member> 객체를 읽어오는 코드");
		
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		try {
			in = new FileInputStream("temp/list.txt");
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			
			ArrayList<ContactVO> list = (ArrayList<ContactVO>)oin.readObject();
			for(ContactVO m : list) {
				System.out.println(m);
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

} // end FileMain07





