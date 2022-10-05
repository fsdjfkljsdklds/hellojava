package co.edu.except;

public class RectPrint {
	public static void main(String[] args) {
		int cnt = 1;
	     for (int j = 0; j < 5; j++) {
	         int num = 1 + j;
	         for (int i = 0; i <5; i++) {
	            cnt = num;
	            num += 5;
	            System.out.print(cnt +"\t");
	         }
	         System.out.println();
	      }
	}
}
