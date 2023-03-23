import java.io.FileInputStream;

public class E04_FileInputStream {

	public static void main(String[] args) {

		try {
			FileInputStream in = new FileInputStream("myFiles/test2.txt");

			// -- 방법 1.
			// read() : 데이터를 한 바이트씩 읽는다. 더 이상 읽을게 없는 경우 -1을 리턴.(EOF(End Of File))
			//			한 바이트씩 읽기 때문에 한글 등의 2바이트 문자를 읽기가 힘들다
//			 int result = 0;
//			 while (true) {
//				result = in.read();
//			 	 if (result == -1) {
//			 	break;
//				}
//					System.out.print((char)result);
//				}

			// -- 방법 2.
			// 모든 내용을 한번에 byte[](바이트형 배열)로 읽기
			// 안에 들은 모든 내용이 문자열이라는 것을 알고 있기 때문에 new String으로 allData를 전달할 수 있다.
			byte[] allData = in.readAllBytes();
			// byte[]을 요구하는 문자열 생성자로 재구성하기
			System.out.println(new String(allData));

			// 더 이상 안 쓸거라면 close
			in.close();
		} catch (Exception e) {
			System.out.println("뭔가 문제 생김");
		}
		System.out.println();
		System.out.println("프로그램 끝");
	}
}
