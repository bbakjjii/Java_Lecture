import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E07_BufferedStream {

	/*
	 	# Buffer
	 	· 데이터를 한 개씩 여러번 입출력하는 것보다 모아서 한 꺼번에 입출력하는 방식이 훨씬 처리 속도가 빠르다
	    · 버퍼 기능이 미리 구현된 스트림 클래스들은 앞에 Buffered라는 이름이 붙는다
		· BufferedInputStream, BufferedReader, BufferedWriter ...

	 				[ CPU ]	
	 				   ↑↓		 
			  	   [ Memory ]
			inputstream↑↓outputstream
			 		[ HDD ]

	 */		

	private static String allText = read2();

	// 연습문제 - 한 글자씩 쓰기
	public static void write0() {
		FileWriter out = null;

		try {
			out = new FileWriter("./write_test/write0.txt");

			int len = allText.length();
			for(int i = 0; i < len; ++i) {
				out.write(allText.charAt(i));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) out.close();				
			} catch (IOException e) {

			}
		}
	}

	// 연습문제 - 직접 구현한 버퍼 방식으로 쓰기
	public static void write1() {
		// AutoClose 방식의 try-catch, ()내부에 선언한 AutoCloseable 타입의 인스턴스들은
		// 자동으로 close()를 호출한다
		try(
				FileWriter out = new FileWriter("./write_test/write1.txt")	
				){
			StringBuilder sb = new StringBuilder(allText);

			int len = allText.length();

			for (int i = 0; i < len; i += 2048) {				
				out.write(allText, i, i + 2048 > len ? len - i : 2048); // i부터 시작해서 2048개 써주세요.
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	// 연습문제 - BufferedWriter로 쓰기
	public static void write2() {
		try (
				FileWriter fout = new FileWriter("./write_test/write2.txt");
				BufferedWriter out = new BufferedWriter(fout);
				){
			out.write(allText);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 연습문제 - 한 글자씩 읽기
	//	public static void read0() {
	//		File book = new File("myFiles/frankenstein.txt");
	//		StringBuilder sb = new StringBuilder();
	//
	//		try {
	//			FileReader in = new FileReader(book);
	//
	//			int ch;
	//			while ((ch = in.read()) != -1) {
	//				sb.append((char)ch);
	//			}
	//
	//			in.close();
	//		} catch (FileNotFoundException e) {
	//			e.printStackTrace();
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}

	// 기존 방식으로 읽기 (FileReader)
	public static void read1() {  

		File book = new File("myFiles/frankenstein.txt");

		StringBuilder sb = new StringBuilder();

		try {
			FileReader in = new FileReader(book);

			// 한개씩 출력하기보다는 모아서 한번에 출력하는 편이 훨씬 빠르다
			char[] cbuf = new char[2048]; // 2048개씩 문자를 읽는다.

			int len;

			while((len = in.read(cbuf)) != -1) {
				sb.append(cbuf, 0, len);
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		// System.out.println(sb);
		// System.out.println("소요 시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	// int ch;
	// while ((ch = in.read()) != -1){
	// sb.append((char)ch);
	// }

	public static String read2() {
		File book = new File("myFiles/frankenstein.txt");
		StringBuilder sb = new StringBuilder();

		try {
			FileReader fin = new FileReader(book);
			BufferedReader in = new BufferedReader(fin);

			// readLine() : BufferedReader에 추가된 한 줄씩 읽는 기능
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);	
				sb.append('\n');
			}

			// 최근에 열었던 순서대로 닫아야 한다
			in.close();
			fin.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void checkTime(long startTime) {
		System.out.println("소요 시간 : " + (System.currentTimeMillis() - startTime) + "ms");
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		read1();
		checkTime(startTime);
		System.out.println("--read1--");

		startTime = System.currentTimeMillis();
		read2();
		checkTime(startTime);
		System.out.println("--read2--");

		startTime = System.currentTimeMillis();
		write0();
		checkTime(startTime);
		System.out.println("--write0--");

		startTime = System.currentTimeMillis();
		write1();
		checkTime(startTime);
		System.out.println("--write1--");

		startTime = System.currentTimeMillis();
		write2();
		checkTime(startTime);
		System.out.println("--write2--");
	}
}