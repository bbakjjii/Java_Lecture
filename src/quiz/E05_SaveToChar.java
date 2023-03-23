package quiz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class E05_SaveToChar {

	/*
	 문제.
	 가위바위보 전적을 FileReader와 FileWriter를 사용해 저장해보세요
	 (가위바위보 로직은 반드시 만들었던 것을 재활용 할 것)
	 */

	public static void main(String[] args) {
		int[] record = new int[3];

		try {
			FileReader in = new FileReader("myFiles/record2.sav");

			char[] buffer = new char[1000];

			int len = in.read(buffer);

			String recordData = new String(buffer, 0, len);

			// Pattern.compile("(\\d+),(\\d+),(\\d+)"); // 그룹 1, 2, 3이 나옴

			String[] split = recordData.split(",");

			for (int i = 0; i < split.length; ++i) {
				record[i] = Integer.parseInt(split[i]);
			}

			in.close();
		} catch (FileNotFoundException e) {

			System.out.println("세이브 파일을 찾지 못했습니다! 새로 시작합니다...");
		} catch (IOException e) {
			System.out.println("읽기 도중 문제 발생");
			e.printStackTrace();
		}

		System.out.println("시작 전적 : " + Arrays.toString(record));

		for (int i = 0; i < 30000; ++i) {
			int result = E04_Save.game();
			// System.out.println("결과 : " + result);
			record[result] += 1;
		}
		System.out.println("종료 전적 : " + Arrays.toString(record));

		try {
			FileWriter out = new FileWriter("myFiles/record2.sav");

			// 전적을 문자열로 변환해서 저장
			out.write(String.format("%d,%d,%d", record[0], record[1], record[2]));

			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("저장 완료.");
	}
}