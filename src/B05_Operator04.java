public class B05_Operator04 {	

	public static void main(String[] args) {					
		int a = 10;				
		a = 20;				
		System.out.println(a);				
		a += 20;				
		System.out.println(a);				
		a *= 2;				
		System.out.println(a);				
		a -= 13;				
		System.out.println(a);				

		a = 10;				
		a = a + 5; // a += 5;				
		a = a * 10; // a *= 10;				
		System.out.println(a);				

		int num = 20;				

		num++;				
		System.out.println(num);				

		++num;				
		System.out.println(num);				

		int result;				
		num = 20;				
		result = num++ + 10; // 20+10++				
		System.out.println("result1: " + result + ", num : " + num);				

		num = 20;				
		result = ++num + 10; // 20++ → 21 + 10 → 31				
		System.out.println("result2: " + result + ", num : " + num);				

		num = 20;				
		result = (num += 3) + 5;				
		System.out.println("result3: " + result + ", num : " + num);				
	}					
}						
