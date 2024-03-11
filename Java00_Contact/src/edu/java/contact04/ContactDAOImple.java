package edu.java.contact04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

//DAO(Data Access Object) :
//- 데이터의 전송을 담당하는 역할
public class ContactDAOImple implements ContactDAO {

	// 싱글톤 디자인 패턴 적용

	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;

	// 2. private 생성자
	private ContactDAOImple() { // 함수를 사용하기 위해 생성자에서 부른다.
		initDataDir();
		initDataFile();
		
	}

	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if (instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}

	// 연락처 저장 배열
	private static ArrayList<ContactVO> list = new ArrayList<>();

	// 데이터를 저장할 폴더와 파일 이름 정의
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "contact.data";

	// data 폴더의 contact.data 파일을 관리할 File 객체 선언
	// 멤버 변수를 선언 하는 이유는 여러군데서 사용하기 때문
	private File dataDir;
	private File dataFile;

	// TODO : data 폴더가 있는지 검사하고, 없으면 생성하는 함수
	private void initDataDir() {
		System.out.println("initDataDir()"); // 코드가 길어지면 시작점이나 문제찾기가 힘들기에 코드를 추가해주면 좋음
		dataDir = new File(DATA_DIR);
		System.out.println("폴더 경로 : " + dataDir.getPath());
		
		if (!dataDir.exists()) { // 파일, 폴더가 없는 경우
			System.out.println("폴더가 없습니다.");
			// mkdir() : 디렉토리를 생성하는 메소드. 성공하면 true, 실패하면 false
			// mkdirs() : 상위 디렉토리를 포함하여 생성하는 메소드.
			if (dataDir.mkdirs()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패");
			}
		} else { // 파일, 폴더가 있는 경우
//			System.out.println("폴더가 이미 존재합니다.");
		}
	}

	// TODO : 데이터 파일이 존재하는지 검사하고,
	// 없는 경우 - 새로운 데이터 파일 생성
	// 있는 경우 - 기존파일에서 데이터를 읽어서 ArrayList에 추가
	private void initDataFile() {
		System.out.println("initDataFile()");
//		String filePath = DATA_DIR + file.separator + DATA_FILE);
//		dataFile = new File(filePath);
		dataFile = new File(DATA_DIR + File.separator + DATA_FILE); // 결과적 하드코딩
		
		if (!dataFile.exists()) { // 데이터파일 존재 여부 검사시작, 존재 안할시
			System.out.println();
			try {
				dataFile.createNewFile(); // 생성
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		} else { // 이미 존재한다면. 데이터를 읽어와서 저장
			System.out.println("파일이 이미 존재합니다.");
			System.out.println("데이터 크기 : " + dataFile.length());
			if(dataFile.length() != 0) { // 존재하는 파일의 내용이 없다면 불러오지않음.
				readDataFromFile();
			}

		} // end if else

	} // end initDataFile

	// TODO : 멤버 변수 list 객체를 data\contact.data 파일에 저장(쓰기)
	// 1. 저장되기 위해선 입력된 정보가 있어야한다.
	// 2. 이미 있는 데이터파일의 존재 여부 확인
	// 2. 입력받은 내용을 저장할 파일과 폴더가 필요하다.
	// 3. 파일과 폴더가 없다면 만들고 있다면 불러온다
	// 4. 입력된 정보를 파일에 저장한다.
	
	private void writeDataToFile() {
		System.out.println("writeDataToFile");
		OutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;

		try {
//			out = new FileOutputStream(dataFile); Ctrl Spacebar에서 보고 
			// FileOutputStream이 받는 데이터를 그대로 넣어도 된다.
			out = new FileOutputStream(DATA_DIR + File.separator + DATA_FILE);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			oout.writeObject(list);
			System.out.println("list 저장 완료.");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oout.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		} // end try-catch-finally

	}

	// 해결하려한 방법 if문으로 DATA_FILE의 존재여부를 판단하고
	// 없다면 생성하려함. 근데 오류
	// TODO : data\contact.data 파일에서 ArrayList 객체를 읽어와서
	// 멤버 변수 list에 저장(읽기)

	private void readDataFromFile() {
		System.out.println("readDataFromFile()");
		InputStream in = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		try {
//			in = new FileInputStream(dataFile); Ctrl Spacebar에서 보고 받아오는걸 그대로 넣어도 된다.
			in = new FileInputStream(DATA_DIR + File.separator + DATA_FILE);
			bin = new BufferedInputStream(in);
			oin = new ObjectInputStream(bin);
			list = (ArrayList<ContactVO>) oin.readObject();
			// 멤버(필드) 변수 list에 contct.data에서 불러온 데이터를저장. 오브젝트 형식은
			// list에 넣을수 없어서 형변환을 해준다.
			System.out.println("데이터 불러옴");
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end try-catch-finally
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		writeDataToFile();
		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {
//		readDataFromFile();  이미 initdataFile로 불러져있기 때문에 굳이 또 부를 필요가 없음	
		return list;
	}

	@Override
	public ContactVO select(int index) {
//		readDataFromFile();
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setName(vo.getName());
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		writeDataToFile();
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		writeDataToFile();
		return 1;
	}

}
