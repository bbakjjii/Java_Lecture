package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E06_Copy {

	/*
	 images 폴더 내부의 모든 내용을
	 원하는 경로의 밑으로 모두 복사해보세요
	 */

	// 디렉토리만 받아서 복사하는 방식
	public static void copyDirectory(File src, File dst) throws Exception { 
		
		// 디렉토리가 아닌 경우 강제 종료. 디렉토리를 전달하지 않으면 복사해주지 않겠다.
		if (!src.isDirectory()) {
			throw new Exception("디렉토리만 전달해 익셉션");
		} else if (!src.exists()) {
			throw new Exception("복사할 파일 경로 틀림 익셉션");
		} else if (!dst.exists()){
			throw new Exception("목적지 경로 틀림 익셉션");
		}
		
		// src : images
		// dst : myFiles
		// to_copy : myFiles/images/
		File to_copy = new File(dst, src.getName());
		
		// myFiles/images/
		to_copy.mkdir();
		
		// 원본 폴더인 images/내부의 파일들
		for (File f : src.listFiles()) { // listFiles() : images/apple.jpg
			if (f.isDirectory()) {
				copyDirectory(f, to_copy); // to_copy : myFiles/images/apple.jpg
			} else if (f.isFile()) {
				// myFiles/images를 부모로 삶고 그 안에 파일의 이름을 전달해서 해당 파일이름으로 가야한다.
				copyFile(f, new File(to_copy, f.getName()));				
			}
		}
	}
	
	public static void copyFile(File srcFile, File dstFile) {
//		FileReader in = null;
//		FileWriter out = null;
		
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(dstFile);	
			
//			char[] cbuf = new char[4096]; // 4096 바이트씩 읽는다
//			
//			int len;
//			while((len = in.read(cbuf)) != -1) {
//				out.write(cbuf, 0, len);
//			}
			
			out.write(in.readAllBytes());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) in.close();
				if (out != null) out.close();
			} catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	public static void copy(File src, File dst) {
		File to_copy = new File(dst, src.getName());
		
		System.out.println("--------------------");
		System.out.println("원본 파일 : " + src);
		System.out.println("복사해야 하는 위치 : " + to_copy);
		
		if (src.isDirectory()) { //원본이 디렉토리면 나도 디렉토리
			to_copy.mkdir();
		} else if (src.isFile()) { // 원본이 파일이면 나도 파일
			copyFile(src, to_copy);
		} else { // 파일도 아니고 디렉토리도 아니면 뭘까?
			System.out.println("?? 복사 종료");
		}
	}
	
	public static void main(String[] args) {
		try{
			copyDirectory(new File("images"), new File("copy_practice"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}