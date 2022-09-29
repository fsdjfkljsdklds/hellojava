package co.edu.variable;

public class MethodExample {

	// 가로, 세로 =>
	public static int getArea(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}

	// 배열요소의 각 값의 합.
	public static int sumAry(int[] Ary) {
		int sum = 0;
		for (int i = 0; i < Ary.length; i++) {
			sum = sum + Ary[i];

		}
		return sum;
	}

	// 두수의 나눈 결과를 반환.
	public static double divide(double d1, double d2) {
		// 1bit * 8 => 1byte.
		// 유형 : byte(1), short(2), int(3), long(8)
		// : float(4), double(8)
		if(d2 == 0) {
			return 0;
		}
		double result = (double) d1 / d2; // 3.0 / 2.0 => 1.5
		return result;
	}
	// 두수를 나누는 작업, 매개변수를 int 지정
	public static double divide(int n1, long n2) {
		double result = n1 / n2; // 3/2 => 1.5
		return result;
	}

	public static void main(String[] args) {
		int result = getArea(20, 15);
		System.out.println("전체 너비는 " + result);

		int[] Ary = { 23, 45, 12 };
		result = sumAry(Ary);
		System.out.println("전체 배열요소의 합계는 " + result);

		// 실수. float, double
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2;

		d3 = divide(d1, d2);
		System.out.println("나눈 결과는 " + d3);
		
		d3 = divide(3, 2);
		System.out.println("나눈 결과는 " + result);
	}
}
