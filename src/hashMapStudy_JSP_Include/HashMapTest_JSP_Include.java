package hashMapStudy_JSP_Include;

import java.util.HashMap;

public class HashMapTest_JSP_Include {
	
	static class Apple {
		int sweet;
		int size;
	}
	
	public static void main(String[] args) {
		
		
		
		
		HashMap<String, String> map1 = new HashMap<>();
		
		// string은 equals와 hashCode가 미리 구현되어 있는 클래스이므로
		
		// 두개가 같으면 값을 덮어 씌워야 한다.
		// 다르다면 key, value가 따로 생긴다.
		// animal의 lion과 tiger가 같은 객체라는 것을 알 수있다.
		// 주소값은 다르지만 안에 들어있는 값은 같기 때문에.
		map1.put(new String("animal"), "lion");
		map1.put(new String("animal"), "tiger");
		
		System.out.println(map1);
	}

}
