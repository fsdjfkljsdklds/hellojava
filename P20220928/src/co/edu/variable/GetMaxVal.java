package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5];
		randomAry[0] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의수 생성.
		randomAry[1] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의수 생성.
		randomAry[2] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의수 생성.
		randomAry[3] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의수 생성.
		randomAry[4] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의수 생성.
		
		int maxVal = 100; // 배열요소 중 가장 큰 값을 저장.
		for(int i=0; i<5; i++) {
			System.out.println(randomAry[i]);
			// maxVal 변수에 두 값을 비교해서 큰 값을 담기.
			if(randomAry[i] < maxVal) {
				maxVal = randomAry[i];			
			}
		}

		System.out.println("생성된 배열의 임의이 값중 최대값 =>" + maxVal);
	}
}
