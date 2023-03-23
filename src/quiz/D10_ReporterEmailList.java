package quiz;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_ReporterEmailList {

	/*
	 문제.
	 1. 어떤 도메인이 몇 개씩 있는지 세어서 출력해 보기 (chosun.com, munhwa.com 등)
	 2. 각 분야의 기자가 몇 명씩 있는지 세어서 출력해보기
	 3. 각 신문사의 기자가 몇 명씩 있는지 세어서 출력해보기
	 */

	public static void dataCount(Map<String, Integer> map, String data) {
		if (map.containsKey(data)) {
			map.put(data,  map.get(data) + 1);
		} else {
			map.put(data,  1);
		}
	}
	
	public static void main(String[] args) {
		
		Pattern reporterInfoPattern = Pattern.compile("(.+)\t(.+)\t(.+)\t(.+@(.+))\r\n");
		
		Matcher matcher = reporterInfoPattern.matcher(text);
		
		HashMap<String, Integer> companyCount = new HashMap<>();
		HashMap<String, Integer> categoryCount = new HashMap<>();
		HashMap<String, Integer> domainCount = new HashMap<>();
		
		while (matcher.find()) {
			String company = matcher.group(1);
			String category = matcher.group(2);
			String domain = matcher.group(5);
			
			dataCount(companyCount, company);
			dataCount(categoryCount, category);
			dataCount(domainCount, domain);
			
			System.out.printf("신문사\t : %s\n", company);
			System.out.printf("전문분야\t : %s\n", category);
			System.out.printf("이름\t : %s\n", matcher.group(3));
			System.out.printf("이메일\t : %s\n", matcher.group(4));
			System.out.println("------------------------------");
		}
		
		System.out.println(companyCount);
		System.out.println(categoryCount);
		System.out.println(domainCount);
		
	}

	public static String text = "조선일보	가정/육아	박은주	zeeny@chosun.com\r\n"
			+ "문화일보	가정/육아	박양수	yspark@munhwa.com\r\n"
			+ "경향신문	가정/육아	황경상	yellowpig@kyunghyang.com\r\n"
			+ "동아일보	가정/육아	우경임	woohaha@donga.com\r\n"
			+ "동아일보	가정/육아	정효진	wiseweb@donga.com\r\n";
}