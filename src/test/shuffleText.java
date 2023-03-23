package test;
import java.util.Scanner;

public class shuffleText {
	
	public shuffleText() {
		
		// ① 사용자로부터 문장 입력 받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문장을 입력하세요. >> ");
		String text = sc.nextLine();
		
//		System.out.println("입력받은 문장 : " + text);
//		
//		System.out.println("----------");
		
		// 아까 한 거 : 1 ~ 45중에 랜덤으로 6개를 중복없이 선택
		// 지금 할 거 : 0 ~ len-1중에 랜덤으로 len개를 중복없이 선택
		// "abcdefg"
		//  ↓ 랜덤한 위치에 하나씩 추가
		// "gefabcd"
		
//		// 방법 1. (어려운 방법)
//		// ② 해당 문장을 랜덤으로 뒤섞어 출력
//		// 중복 없이 모든 인덱스를 선택하면 문자를 섞을 수 있음.
//		String shuffled = ""; // * 문자열을 한번에 모아서 출력 ★★
//		int len = text.length();
//		int[] indexs = new int[len];
//		for (int i = 0; i < text.length(); ++i) {
//			indexs[i] = (int)(Math.random() * len);
//			
//			// ③ 중복제거 : hello를 입력했을 때 olhlh가 나올 수 있기 때문에 중복을 없애는 것.
//			for (int j = 0; j < i; ++j) {
//				if (indexs[i] == indexs[j]) {
//					indexs[i] = (int)(Math.random() * len);
//					j = -1;
//				}
//			}
//			shuffled += text.charAt(indexs[i]); // * 문자열을 한번에 모아서 출력
//		}
//			System.out.println(shuffled); // * 문자열을 한번에 모아서 출력
//	}
//	System.out.println("----------");
			
//		// 방법 2.
//		// 꺼낸 다음 표시하기
//		// 이미 들어있으면 다른 곳에 넣기		
//		char[] origin = text.toCharArray(); // 원본 // 한번에 입력하기 위해 toCharArray를 사용함.
//		char[] dst = new char[origin.length]; // 결과물
//		// ↑ 배열 : 타입[] 변수명 = new 타입[크기];
//		// destination : 목적지 = 결과물
//		
//		// origin에서 순서대로 하나씩 꺼내서 dst의 랜덤 위치에 저장
//		for (int i = 0; i < origin.length; ++i) {
//			int random_index = (int)(Math.random() * origin.length);
//			
//			// random_index에 다른 문자가 들어간 적이 없으면 옮김
//			if (dst[random_index] == 0) {
//				// ↑ 아무 글자도 없는 곳 null = 0
//				dst[random_index] = origin[i];
//			} else {
//				// ↑ 글자가 있으면
//				// random_index에 다른 문자가 이미 들어가 있다면
//				// 새로운 random_index를 선정함
//				--i;
//			}			
//		}
//		// new String(char[])을 통해 char[]을 다시 문자열로 만들 수 있음
//		System.out.println("원본 : " + new String(origin));
//		System.out.println("섞은 후 : " + new String(dst));
//		System.out.println("----------");
		
		
		
//		// 방법 3.
//		char[] origin = text.toCharArray(); // 원본 
//		char[] dst = new char[origin.length]; // 결과물
//		
//		// origin에서 순서대로 하나씩 꺼내서 dst의 랜덤 위치에 저장
//		for (int i = 0; i < origin.length; ++i) {
//			int random_index = (int)(Math.random() * origin.length);
//			
//			// origin에서 임의로 선택한 위치에 제대로 된 문자가 있다면
//			if (origin[random_index] != 0) {
//				// dst로 복사한 후 그곳을 0으로 만든다.
//				dst[i] = origin[random_index];
//				origin[random_index] = 0;
//				// ↑ 하나씩 0으로 입력 됨. {0, 0, 0, 0}, String에서 0은 null값과 동일
//				// origin에서 빠진 값이 dst로 옮겨감(?)
//				// 그렇기 때문에 하단에 origin 출력시에는 null값으로 값이 나오지 않음
//			} else {
//				--i;
//			}
//
//		}
//		System.out.println("원본 : " + new String(origin)); // 값이 나오지 않음. null값
//		System.out.println("섞은 후 : " + new String(dst));
		
		
		// 방법 4.
		// "ABCDEFG"
		//  ↓ 랜덤으로 섞기
		// "GBAEFDC" 	

		char[] shuffleArray = text.toCharArray(); // 원본
		
		// 랜덤 위치의 문자를 선택해 첫 번째 문자와 만번 교환하기
		for (int i = 0; i < 10000; ++i) { // 1만번 섞기. 몇번 섞든 상관은 없다.
			int random_index = (int)(Math.random() * text.length()); // 문자열 길이만큼 (?)
			
			
//			// 변수에 저장된 두 값을 교체할 때는 변수가 하나 더 필요하다.
//			// 값을 잠시 담아 놓을 수 있는 변수가 하나 더 필요하다.
//			int a = 10;
//			int b = 20;
//			int c; // c라는 변수를 만들어 c에 a를 잠깐 보관
//			
//			c = a;
			
//			a = b;
//			b = c;
//			// ↑ a의 값을 b로 b의 값을 a로 바꾸고 싶다!
			
			//문자열에다가 값을 넣을 순 없다. 그래서 수정이 가능한 형태인 배열로 바꾼다.
			char temp = shuffleArray[0]; // 값을 잠깐 담아놓을 변수
			shuffleArray[0] = shuffleArray[random_index]; 
			shuffleArray[random_index] = temp; // 임시로 보관한 것을 넣음	
		}
		System.out.println("셔플 결과 : " + new String(shuffleArray)); // 다시 문자열로 만들어서 출력	
	}
	
	public static void main(String[] args) {
		shuffleText shffletext = new shuffleText();
	}
}
