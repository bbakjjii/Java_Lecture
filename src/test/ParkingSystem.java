package test;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ParkingSystem {

   public static String checkRestricted(Car car, LocalDate date) {
       if (car.getType() == CarType.DISABLED) {      
         return String.format("[%s] 장애인 차량은 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      } else if (car.getType() == CarType.KID) {
         return String.format("[%s] 유아동승 차량은 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      } else if (car.getType() == CarType.EMERGENCY) {
         return String.format("[%s] 긴급 차량은 차량5부제 제외차량입니다.", 
               car, date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
      }
       
       
       char lastNum = car.getNumber().charAt(car.getNumber().length() - 1);
       
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
      
      for (int i = 0; i < 100; ++i) {
         cars.add(new Car());
      }
      
      LocalDate checkDay = LocalDate.now();
      final int A_WEEK = 7;
      
      for (int i = 0; i < A_WEEK; ++i) {
         System.out.println(checkDay.getDayOfWeek() + " TEST : ");
         
         for (Car car : cars) {
            String result = checkRestricted(car, checkDay);
            System.out.println("\t" + result);
         }
         checkDay = checkDay.plusDays(1);
      }
   }
   
} 