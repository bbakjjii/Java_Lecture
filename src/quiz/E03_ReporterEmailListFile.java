package quiz;

import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E03_ReporterEmailListFile {

	/*
	 문제.
	 기자들의 이메일들로만 이루어진 파일을 생성해보세요.
	 */
	
	public static void main(String[] args) {

		Pattern emailPattern = Pattern.compile("\\S+@\\S+");
		Matcher matcher = emailPattern.matcher(D10_ReporterEmailList.text);

		try {
			// FileOutputStream의 두 번째 매개변수를 true로 하면 append 모드가 된다.
			FileOutputStream out = new FileOutputStream("myFiles/email_list.txt", true); // 누적 : append(,true) 사용
			// 정규표현식을 찾을 때마다 반복
			while (matcher.find()) {
				out.write((matcher.group(0)).getBytes());
				out.write('\n');
			} 
			out.close();
		} catch (Exception e) {
			System.out.println("파일을 찾을 수 없거나 쓰기 도중 에러 발생..");
		}
		System.out.println("프로그램 종료.");
	}
}