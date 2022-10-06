package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {

		int num = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("   "+num++);
			}
			System.out.println();
		}

		System.out.println("==============");
		int num1 = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j > 0; j--) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print(num1++);
				}
			}
			System.out.println("");
		}
	}
}
