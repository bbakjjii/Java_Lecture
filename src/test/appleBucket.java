package test;
import java.util.Scanner;

public class appleBucket {

	public appleBucket() {
		Scanner sc = new Scanner(System.in);

		System.out.print("사과 개수를 입력해보세요. >> ");	
		int appleQty = sc.nextInt(); // 입력 받는 숫자
		int basketSize = 10;
		int answer;

		 answer = (int)Math.ceil(appleQty / (double)basketSize); // 정답 2. if문 없이 Math.ceil 사용

		// ★ 잘못된 입력에 대한 검증은 가장 먼저 하는 것이 좋다.
		if (appleQty <= 0){
			answer = 0;
		} else if (appleQty % basketSize > 0) {		
			answer = appleQty / basketSize + 1;			
		} else {
			answer = appleQty / basketSize;			
		}		

		System.out.printf("필요한 바구니의 개수는 %d개 입니다 ", answer);

	}
	
	public static void main(String[] args) {
		appleBucket applebucket = new appleBucket();
	}

}
