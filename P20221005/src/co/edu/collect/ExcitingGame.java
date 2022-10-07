package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String target = "a b c d e f g h i";
		System.out.println(target);
		String[] targetAry = target.split(" ");

		boolean done =false;
		long gameStart = System.currentTimeMillis();
		while(true) {
			done = true;
			System.out.println("입력");
			String type = scn.nextLine();
			for(int i=0; i<targetAry.length; i++) {
				if(targetAry[i] != null && targetAry[i].equals(type)) {
					targetAry[i] = null;
							
				}
			}
		for (String str : targetAry) {
			if(str != null) {
				System.out.printf("%s ", str);
				done = false;
			}
		}
		if(done) {
			break;
			}
		
		}
		long gameEnd = System.currentTimeMillis();
		System.out.println((gameEnd - gameStart)/1000);

	}
}
