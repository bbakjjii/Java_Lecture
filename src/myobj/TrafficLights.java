package myobj;

public class TrafficLights {
	
	public int time; 
	public static String color;
	public static String notice;
	
	public TrafficLights() { 
		color = "green";
		notice = "건너세요";
		time = 60;
	}
	
	public TrafficLights(int time) { 
		this.color = color;
		this.notice = notice;
		this.time = time;
	}
	
	public static void ChangeColor(String color) {
		TrafficLights.color = color;

	}
	
	public static void ChangeNotice(String notice) {
		TrafficLights.notice = notice;

	}
		
	public void info() {
		System.out.printf("%s : %s - %d초 남았습니다.\n", color, notice, time);
	}
}

