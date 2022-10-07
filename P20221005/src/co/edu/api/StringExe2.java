package co.edu.api;

import java.io.IOException;

public class StringExe2 {
	public static void main(String[] args) {
//		System.out.println("abcDEF".toLowerCase());
//		System.out.println("abcDEF".toUpperCase());
		while (true) {
			try {
				byte[] arr = new byte[4];
				System.in.read(arr);
				String str= new String(arr);
				changeCapital(str);
				System.out.println();

		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}
		//대문자 ->소문자, 소문자->대문자(소문자 대문자 차이 32)
		//aBcD => AbCd 97:65, 98:66     122
		//소문자 : 97 ~ 122, 대문자 : 65 ~ 90
	} public static void changeCapital (String msg) {
		String[] msgAry = msg.split("");
		byte[] bytes = new byte[msg.length()];
		int i = 0;
		for(String str : msgAry) {
			char chr = str.charAt(0);
			int chr2 =0;
			if(chr>=92)
				chr2 = chr -32;
			else if(chr<=92)
				chr2 = chr +32;
			System.out.println((char)chr2);

		}
	}

}
