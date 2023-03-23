import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E03_JavaIO {

/*
# Java I/O (Input/Output)
· 자바는 스트림이라는 개념을 이용해 프로그램의 입/출력을 다룬다
· 프로그램으로 들어오는 모든 데이터들을 입력(Input)이라고 부른다
· 프로그램에서계산되어 나가는 모든 데이터들을 출력(Output)이라고 부른다

# Stream
· 데이터들이 오고 가는 통로
· 데이터들이 프로그램으로 들어오는 통로를 InputStream이라고 한다
· 데이터들이 프로그램에서 계산되어 나가는 통로를 OutputStream이라고 한다
· 데이터가 Stream을 지나가기 위해서는 해당 데이터를 byte타입으로 변환시켜야 한다.
	(byte타입이 0과 1로 변환하기 가장 쉽기 때문에)
*/
	
	public static void main(String[] args) {
		
		// 예외처리
		// 내용(--에서--까지) 입력 후  → JavaStudy 선택 → 마우스 우클릭 → [New] → [Folder] → myFiles 폴더 만들기 
		// → JavaIO에서 Ctrl+F11 → 콘솔창 : 쓰기 완료 → 패키지창의 [myFile] 선택 후 새로고침 : F5 → myFiles에 text.txt파일 생성
		try {
		FileOutputStream out = new FileOutputStream("myFiles/test.txt"); // 경로 설정
		
		out.write('A');
		out.write('B');
		out.write('C');
		out.write('\n');
		
		// String.getBytes() : 해당 문자열을 byte[]로 변환한 값을 리턴
		out.write("Hello, File!\n".getBytes());
		
		// 다 사용한 Stream은 반드시 닫아줘야 한다
		out.close();
	} catch (FileNotFoundException e) {
		System.out.println("해당 경로를 못 찾음..");
		return;
	} catch (IOException e){
		System.out.println("Write 도중 에러 발생..");
		return;
	}
		System.out.println("쓰기 완료."); 
	}
}