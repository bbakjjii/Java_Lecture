import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class D14_Time {

	/*
		# java.time.*
		· Calendar의 여러가지 단점을 보완한 시간을 다루는 클래스
		· set(), add()를 통해 원본 인스턴스를 변경하는 방식이 아니라
			새로운 시간 인스턴스를 반환하는 방식을 사용한다
		· LocalDate(날짜만), LocalTime(시간만), LocalDateTime(날짜와 시간)
	 */

	public static void main(String[] args) {

		// now() : 현재 시간의 인스턴스를 반환하는 메서드
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println("-----");

		// of() : 원하는 시간의 인스턴스를 반환하는 메서드
		LocalDate date;
		LocalTime time;
		System.out.println(date = LocalDate.of(1998, 8, 15));
		System.out.println(time = LocalTime.of(19, 38, 55, 123456789)); // 시, 분, 초, 999999999 : 나노세컨드
		System.out.println(LocalDateTime.of(date, time));
		System.out.println("-----");

		// plusXXX() : 해당 항목을 원하는만큼 더한 인스턴스를 반환한다
		// minusXXX() : 해당 항목을 원하는만큼 뺀 인스턴스를 반환한다
		LocalDate today = LocalDate.now();		
		LocalDate before100days = today.minusDays(100);
		LocalDate after100days = today.plusDays(100);
		LocalDate after100years = today.plusYears(100);
		today.plusDays(100);

		System.out.println(today);
		System.out.println(before100days);
		System.out.println(after100days);
		System.out.println(after100years);
		System.out.println("-----");

		// isAfter(), isBefore()로 인스턴스간 시점 비교가 가능 (누가 더 앞/뒤에 있는가?)
		System.out.println(after100days.isAfter(after100years)); // 100일이 100년보다 뒤에 있니? ⇒ false
		System.out.println(after100days.isBefore(after100years)); // 100일이 100년보다 앞에 있니? ⇒ true
		System.out.println("-----");

		// getXXX()으로 원하는 필드만 꺼내는 것도 가능
		System.out.println(date.getDayOfMonth()); // return 타입 = int
		System.out.println(date.getDayOfYear()); // return 타입 = int
		System.out.println(date.getMonthValue()); // return 타입 = int
		System.out.println("-----");

		// getDayOfWeek()는 int가 아닌 DayOfWeek 타입 인스턴스를 반환
		DayOfWeek dayOfWeek = date.getDayOfWeek(); // return 타입 = dayOfWeek
		System.out.println(dayOfWeek);
		System.out.println(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		System.out.println(dayOfWeek.getValue());
		System.out.println("-----");

		// TemporalAdjusters 클래스 : 날짜 조정 기능들이 모여있는 클래스
		//							메서드를 실행하면 TemporalAdjuster를 반환한다
		// 조정기들 클래스에서 조정기 ta1을 꺼낸다.
		TemporalAdjuster ta1 = TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.WEDNESDAY); // 세번째 수요일
		TemporalAdjuster ta2 = TemporalAdjusters.lastDayOfMonth(); // 이번달의 마지막 날
		TemporalAdjuster ta3 = TemporalAdjusters.next(DayOfWeek.THURSDAY); // 다음주 목요일
		TemporalAdjuster ta4 = TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY); // 오늘을 포함한 돌아오는 목요일

		// with(날짜조정기) : 해당 날짜에 날짜 조정기를 적용한 날짜 인스턴스를 반환
		LocalDate 세번째수요일 = today.with(ta1);
		System.out.println(세번째수요일); // 세번째 수요일 11월 16일

		LocalDate 이번달마지막날 = today.with(ta2);
		System.out.println(이번달마지막날);

		LocalDate 돌아오는목요일 = today.with(ta3);
		System.out.println(돌아오는목요일);

		LocalDate 돌아오는목요일오늘포함 = today.with(ta4);
		System.out.println(돌아오는목요일오늘포함);
	}
}
