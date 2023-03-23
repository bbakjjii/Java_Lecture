
public class B07_Indent {
	
/*
 # Indent : 들여쓰기
 · {}중괄호 내부에서는 한 번 들여쓰기 한다
 · 들여쓰기를 통해 어떤 것이 내부에 있는지 아주 쉽게 판별할 수 있다.
 · 들여쓰기를 지키는것은 기본중의 기본이다.
 · ()와 {}를 일단 닫고 사이에 내용을 적는 것이 좋다.
   - 중괄호를 열고 닫은 뒤 커서를 중괄호 안에 넣고 엔터친다.
 · Ctrl + Shift + F를 누르면 Eclipse가 띄어쓰기 및 들여쓰기를 자동으로 해주긴 한다.
   - 대신 주석이 망가진다.
 · 블록지정 후 Ctrl + i로도 들여쓰기를 맞출 수 있다.
 */
	
	public static void main(String[] args) {

		int a, b, c;
		int x = 10;

		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
	}
}
