package co.edu.variable;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = { 191203, 1920, 69, 11123, 25, 43, };
		
		// 반복적인 처리.
//		numAry = {12, 21, 34} 배열순서 바꾸기
		// 케이스 : n1 > n2 > n3 =>
		// 케이스 : n1 < n2 > n3 =>
		
		for(int j=0; j<numAry.length-1 ; j++) {
			for(int i=0; i<numAry.length -1; i++) {
				if(numAry[i] > numAry[i+1]) {
					int temp = 0;
					temp = numAry[i];
					numAry[i] = numAry[i+1];
					numAry[i+1] = temp;
				}
			}
		}
		for(int n : numAry) {
		System.out.print(n + " ");
	}
//		if(numAry[0] > numAry[1]) {
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; 
//			numAry[1] = temp;  
//		}
//		
//		for(int n : numAry) {
//			System.out.print(n + " ");
//		}
//		
//		if(numAry[1] > numAry[2]) {
//			int temp = numAry[1];
//			numAry[1] = numAry[2]; 
//			numAry[2] = temp; // 
//		}
//		
//		for(int n : numAry) {
//			System.out.print(n + " ");
//		}
//		
//		if(numAry[0] > numAry[1]) { 
//			int temp = numAry[0];
//			numAry[0] = numAry[1];
//			numAry[1] = temp;
//		}
//		
//		for(int n : numAry) {
//			System.out.print(n + " ");
//		}
		

	}

}
