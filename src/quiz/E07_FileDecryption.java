package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class E07_FileDecryption {

	/*
	 문제.
	 암호화 된 파일의 맨 위부터 50줄을 모든 키값(1~25)으로 복호화한 샘플을 보여준 후
	 사용자가 샘플을 보고 key값을 선택할 수 있도록 만들고 
	 해당 키값으로 복호화한 frankenstein_decrypted.txt가 생성되도록 만들어보세요
	 */

	public static void printSamples(File crypto) {
		try (
				FileReader fin = new FileReader(crypto); // Reader : char 단위로 읽기
				BufferedReader in = new BufferedReader(fin); // Buffered : 줄 단위로 읽기
				){
			StringBuilder sampleSrc = new StringBuilder(); // 문자열을 빠르게 조립할 때 사용하는 클래스 (+= 보다 훨씬 빠르다)

			for (int i = 0; i < 10; ++i) {
				sampleSrc.append(in.readLine());
				sampleSrc.append('\n');
			}

			// D09_CaesarCipher : setKey() 생성
			for (int key = 1; key <= 25; ++key) {
				D09_CaesarCipher cryptoTool = new D09_CaesarCipher(1);
				// D09_CaesarCipher : setKey() 생성
				cryptoTool.setKey(key);
				System.out.printf("### key %d ###\n\n", key);
				System.out.println(cryptoTool.decrypt(sampleSrc.toString()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	// -- 연습 -- 내가 짠 코드 : 파일 전체 복호화
	public static File decryptFile(File target, int key) throws Exception {
		if (!target.isFile()) {
			throw new Exception("파일이 아닌 것은 복호화 할 수 없음");
		} else if (!target.getName().endsWith(".enc")) {
			throw new Exception(".enc 파일만 복호화 할 수 있음");
		} 

		File decryptedFile = new File(target.getParentFile(), 
				target.getName().replaceAll("[_].+[.].+", "_decryted.txt"));

		System.out.println(decryptedFile.getAbsolutePath());// 절대경로 리턴

		try (
				FileReader fin = new FileReader(target);
				BufferedReader in = new BufferedReader(fin);
				FileWriter fout = new FileWriter(decryptedFile);
				BufferedWriter out = new BufferedWriter(fout);
				){
			D09_CaesarCipher decryptoTool = new D09_CaesarCipher(key);

			String line;
			while ((line = in.readLine()) != null) {
				out.append(decryptoTool.decrypt(line));
				out.append('\n');
			}
		}
		return decryptedFile;

	}
	// -- 연습 -- 내가 짠 코드 : 파일 전체 복호화




	public static void main(String[] args) throws Exception {

		// InputStream을 Reader로 업그레이드 하는 클래스
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(isr);

		File target = new File("myFiles/frankenstein_encrypted.enc");

		printSamples(target); // key 10이 정답

		while (true) {
			try {
				System.out.print("원하는 key를 입력 >> ");
				String line = in.readLine();

				int key = Integer.parseInt(line.trim());

				// decryptFile(File target, int key)을 이용한 전체 복호화 사용
				decryptFile(target, key);

				break;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("key는 숫자로 입력해주세요");
			}
		}
		System.out.println("복호화 파일이 생성되었습니다.");


		/*
		 	# Stream에 대한 close를 반드시 해야하는 이유

		 	- 사실 모든 참조형 변수는 close가 필요하다
		 	- 하지만 참조형 변수의 닫는 타이밍은 뻔하기 때문에 자동으로 닫아주는 프로그램(Garbage Collector)이 알아서 닫는다
		 	- 하지만 Stream등 닫는 타이밍이 뻔하지 않은 클래스들은 자동으로 닫아주지 않는다
		 	- 만약 계속 닫지 않으면 결국 메모리가 가득 차서 프로그램이 운영체제에 의해 강제 종료 된다
		 */

		try {
			if (in != null) in.close();
			if (isr != null) isr.close();
		} catch (IOException e) {
			System.out.println("close 도중 에러 발생 (한번도 본 적 없음"); 	
		}
	}
}