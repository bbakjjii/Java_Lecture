import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import myobj.Peach;

public class D07_HashMap {

	/*
# Map
· 데이터를 Key/Value 방식으로 저장하는 자료구조
· 인덱스 번호 대신 Key값을 이용해 Value에 접근한다.
· Key값은 중복을 허용하지 않는다.

	 */


	public static void main(String[] args) {
		// <Key값의 제네릭타입, Value값의 제네릭타입> : 제네릭에 2개의 타입을 지정
		HashMap<String , Peach> map1 = new HashMap<>();

		// put(K, V) : 해당키에 값을 저장한다
		map1.put("김민호", new Peach());
		map1.put("먹던것", new Peach());
		System.out.println(map1);

		// get(K) : 키값에 해당하는 Value를 꺼낸다. 키를 찾지못하면 null이 반환됨
		Peach p1 = map1.get("최민호");
		Peach p2 = map1.get("김민호");

		System.out.println(p1);
		System.out.println(p2);
		System.out.println("----------");

		// 네비게이션 예시
		HashMap<String , String> navi = new HashMap<>();

		// 회원등록 예시
		// 이 주민등록번호 또는 전화번호를 가진 회원의 이름으로 하면 안된다.
		// ⇒ Key값에는 중복이 들어갈 수 없다. 중복이 되면 전 내용이 삭제되고 새로운 내용이 들어간다.
		// ⇒ 이메일이나 전화번호처럼 중복이 없는 내용을 넣어야 한다.
		// HashMap<String , MemberInfo> members = new HashMap<>(); 

		navi.put("우리 집", "서울시 무슨구 무슨동 무슨무슨아파트 XXX-XXXX");
		navi.put("회사", "서울시 XX구 가산디지털단지 XXX밸리 XXX-XXXX");
		navi.put("마트", "...");

		System.out.println(navi);
		System.out.println("----------");

		// putIfAbsent(K, V) : 새로운 등록일때만 키와 데이터를 추가한다. (null을 리턴)
		//					   이미 키와 데이터가 존재하면 들어있는 값을 리턴한다. (데이터 수정 X)
		String existValue = navi.putIfAbsent("우리집", "경기도 구리시");
		navi.put("마트",  "서울특별시 구로구 디지털로32길 43");

		System.out.println(existValue);
		System.out.println(navi);
		System.out.println("----------");

		// Map 탐색 방법
		// KeySet() : 해당 맵의 키들로 이루어진 Set을 반환한다.
		Set<String> keys = navi.keySet();

		for (String key : keys) {
			System.out.printf("%s=%s\n", key, navi.get(key));
		}
		System.out.println("----------");

		// values() : 해당 맵의 value들로 이루어진 Collections을 반환한다
		List<String> valueList = new ArrayList<>(navi.values());

		for (String value : valueList) {
			System.out.println(value);
		}
		System.out.println("----------");

		// containsKey(key) : Map의 키값에 해당 키가 있는지 알려준다
		System.out.println(navi.containsKey("우리집"));
		System.out.println(navi.containsKey("초밥무한리필"));
		System.out.println("----------");

		// containsValue(value) : Map의 값에 해당 값이 있는지 알려준다.
		System.out.println(navi.containsValue("..."));
	}
}
