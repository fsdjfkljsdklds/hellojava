package co.edu;

public class Singleton {
	// private 정적필드 
	private static Singleton Singleton = new Singleton();
	// private 생성자.
	private Singleton() {
		
	}
	//public getInstance(); 생성자를 만들 수 있음.
	public static Singleton getInstance() {
		return Singleton;
	}

}
