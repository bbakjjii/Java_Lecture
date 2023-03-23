package myobj;

public class Subway {
	
	// 지하철 노선도
	// 현재역>다음역을 찍어주기 배열 사용
	// {"시청", "종각", "종로3가","종로5가"}
	public String[] stations; 
	public int current_station; // 현재 어떤 역에 있는지?
	public int line; //몇호선인지?
	
	// 열차의 현재 방향을 나타내는 값
	// 지하철의 순환방향
	// true는 기본 오른쪽(정방향)으로 진행, false는 왼쪽(역방향)으로 진행
	public boolean direction = true; 
	
	// 해당 열차가 순환선인지를 나타내는 값
	public boolean rotate;	
		
	// ↓※ 인스턴스 메서드를 만들 때는 static을 사용하지 않는다.
	// ①③ 열차의 현재 위치를 실제로 다음 역으로 변경하는 메서드
	// 순환선이라면 nextRotateStation이 진행,
	// 순환선이 아니라면 nextStation이 진행된다.
	public void next() {
		current_station = rotate ? nextRotateStation() : nextStation();
	}
	
	// ②
	// 다음 역이 무엇인지 계산하여 반환하는 메서드
	public int nextStation() {
		// 현재가 마지막 역이라면 왼쪽으로(역방향) 바꾼다. (지하철 순환)
		if (current_station == stations.length - 1) {
			direction = false;//			
		// 현재역이 출발점이면 오른쪽(정방향)으로 쭉 가겠다.
		} else if (current_station == 0) {
			direction = true;
		}
		// 방향에 따라 오른쪽으로 갈지 왼쪽으로 갈지 여기서 결정하겠다.
		return current_station + (direction ? 1 : -1);
	}
	
	// ③ 2호선 순환열차 만들기
	public int nextRotateStation() {
		// 맨 마지막 역일 때 맨 처음역으로 돌아간다.
		if (direction && current_station == stations.length - 1) {
			return 0;
			// 맨 처음 역일 때 맨 마지막역으로 돌아간다.
		} else if (!direction && current_station == 0) {
			return stations.length - 1;
		}
		return current_station + (direction ? 1 : -1);
	}

	// ①②③
	public void information() {
		System.out.println("--------------------");
		System.out.printf("이 열차는 %d호선 열차입니다.\n", line);
		System.out.printf("현재 역은 %s역 입니다. \n", 
				stations[current_station]);
		System.out.printf("다음 역은 %s역 입니다.\n",
				stations[rotate ? nextRotateStation() : nextStation()]); // nextStation()메서드를 실행
	}
}
