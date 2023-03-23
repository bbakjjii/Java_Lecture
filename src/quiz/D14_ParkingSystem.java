package quiz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import myobj2.parking.Car;
import myobj2.parking.CarType;

public class D14_ParkingSystem {
   /*
      # 승용차 요일제 시행에 따른 차량 진입통제 안내      
      월요일   화요일   수요일   목요일   금요일
      1, 6   2, 7   3, 8   4, 9   5, 0   
      1) 공휴일(음력 적용 안되는 것만)   --> 모든 차량 출입 가능
         신정 (1월 1일), 3.1절 (3월 1일), 어린이날 (5월 5일), 현충일 (6월 6일), 제헌절 (7월 17일),
         광복절 (8월 15일),    개천절(10월 3일), 한글날(10월 9일), 크리스마스 (12월 25일)
      2) 요일별로 차량의 끝번호에 따라 출입을 허가 또는 통제한다.   
      3) 장애인, 유아동승, 경차 등은 제외되므로 출입 가능
   */
   
	
	// LocalDate와 Car를 매개변수로 받아 출입제한 체크
   public static String checkRestricted(Car car, LocalDate date) {
      // CarType은 메모리상에 4개뿐이므로 ==으로 비교가 가능하다 (equals로 비교하지 않아도 됨, 주소가 아니라 값이 같아야 함)
       if (car.getType() == CarType.DISABLED) {      
         return String.format("[%s] 장애인 차량은 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      } else if (car.getType() == CarType.KID) {
         return String.format("[%s] 유아동승 차량은 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      } else if (car.getType() == CarType.LIGHTCAR) {
         return String.format("[%s] 경차는 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      }
       
       // 마지막 글자
       char lastNum = car.getNumber().charAt(car.getNumber().length() - 1);
       
       // &&는 ||보다 먼저 연산되므로 주의해야 한다
       if ((lastNum == '1' || lastNum == '6') && date.getDayOfWeek() == DayOfWeek.MONDAY) {
          return String.format("[%s] %s 출입금지입니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       } else if ((lastNum == '2' || lastNum == '7') && date.getDayOfWeek() == DayOfWeek.TUESDAY) {
          return String.format("[%s] %s 출입금지입니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       } else if ((lastNum == '3' || lastNum == '8') && date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
          return String.format("[%s] %s 출입금지입니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       } else if ((lastNum == '4' || lastNum == '9') && date.getDayOfWeek() == DayOfWeek.THURSDAY) {
          return String.format("[%s] %s 출입금지입니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       } else if ((lastNum == '5' || lastNum == '0') && date.getDayOfWeek() == DayOfWeek.FRIDAY) {
          return String.format("[%s] %s 출입금지입니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       } else {
          return String.format("[%s] 주차 가능합니다", car, 
                date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
       }
   }
   
   public static void main(String[] args) {
      List<Car> cars = new ArrayList<>(100);
      
      for (int i = 0; i < 10; ++i) {
         cars.add(new Car());
      }
      
      LocalDate checkDay = LocalDate.now();
      final int A_WEEK = 7;
      
      for (int i = 0; i < A_WEEK; ++i) {         // 7보다는 변수명 만드는 것이 더 좋다
         System.out.println(checkDay.getDayOfWeek() + " TEST : ");
         
         // 자동차들 하나씩 꺼내면서 테스트하기
         for (Car car : cars) {
            // test
            String result = checkRestricted(car, checkDay);
            System.out.println("\t" + result);
         }
         checkDay = checkDay.plusDays(1);
      }
   } 
} 