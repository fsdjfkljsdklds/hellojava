package co.edu.variable;

public class MethodCalendar {

	public static void main(String[] args) {
		makeCal(3); // 호출.
	}

	public static void makeCal(int month) {
		// 요일 출력.
		System.out.println(">>>>>>>>>>>>" + month + "월<<<<<<<<<<<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 1일의 위치 지정.
		for (int i = 0; i < getFirstDay(month); i++) {
			System.out.printf("%4s", " ");
		}
		// 날짜 출력.
		for (int i = 1; i <= getLastDate(month); i++) {
			System.out.printf("%4s", i);
			if ((i + getFirstDay(month)) % 7 == 0) {
				System.out.println();
			}

		}

	} // end of makeCal()

	public static int getFirstDay(int month) {
		switch (month) {
		case 1:
			return 6;
		case 2:
			return 2;
		case 3:
			return 2;
		case 4:
			return 5;
		case 5:
			return 0;
		case 6:
			return 3;
		case 7:
			return 5;
		case 8:
			return 1;
		case 9:
			return 4;
		case 10:
			return 6;
		case 11:
			return 2;
		case 12:
			return 4;
		default:
			return 0;

		}

	}// end of getFirstDay()

	public static int getLastDate(int month) {
		// switch..case..구문.
		switch (month) {
		case 1:
			return 31;
		case 2:
			return 28;
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		default:
			return 30;

		}
	}

}
