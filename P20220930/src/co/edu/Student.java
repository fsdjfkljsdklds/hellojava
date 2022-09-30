package co.edu;

public class Student {
	// 필드
	private String num;
	private String name;
	private String major;
	private int age; // 정수값 23, 0, -12
	private String[] hobbies = new String[5];
	
	//정적메소드
	public static void staticMethod() {
		System.out.println("staticMethod call.");
	}

	// 생성자(필드의 값을 초기화) 생성자 오버로딩(동일한 이름의 생성자를 여러번 정의)
	public Student() {
		// 매개값이 없는 생성자 => 기본생성자.
		this.name = "기본값";
		this.num = "000-000";
	}

	public Student(String num, String name) {
		this.num = num;
		this.name = name;
	}

	public Student(String num, String name, String major) {
		this(num, name); // 기본생성자.
		this.major = major;
	}

	public Student(String num, String name, String major, int age) {
		this(num, name, major);
		this.age = age;
	}

	// 메소드.
	void setNum(String num) {
		this.num = num;
	}

	String getNum() {
		return this.num;
	}

	// 학생이름 set,get
	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return this.name;
	}

	// 전공 set,get
	void setMajor(String major) {
		this.major = major;
	}

	String getMajor() {
		return this.major;
	}

	void setAge(int age) {
		if (age < 0) {
			this.age = 0;
		} else {
			this.age = age;
		}
	}

	int getAge() {
		return this.age;
	}

	void setHobbies(String[] hobbies) {
//		this.hobbies = hobbies;
		for (String hobby : hobbies) {
			for (int i = 0; i < this.hobbies.length; i++) {
				if (this.hobbies[i] == null) {
					this.hobbies[i] = hobby;
					break;
				}
			}
		}
	}

	String[] getHobbies() {
		return this.hobbies;
	}

	String getHobb() {
		String str = "취미는 ";
		for (String hobby : hobbies) {
			if (hobby != null)
				str += hobby + " ";
		}
		str += "입니다.";
		return str;
	}

	// 취미추가.
	void addHobby(String hobby) {
		for (int i = 0; i < hobbies.length; i++) {
			if (hobbies[i] == null) {
				hobbies[i] = hobby;
				break;
			}

		}

	}

	// showInfo()
	public String showInfo() {
		return "이름은 " + this.name + "이고 학번은 " + this.num + "입니다. 전공은 " + this.major + "이고 나이는 " + this.age + "입니다.";
	}

	void study() {
		System.out.println(name + "은 " + major + "에 다닙니다.");
	}

	void game() {
		System.out.println(name + "은 게임합니다.");
	}

	void sleep() {
		System.out.println(name + "은 잡니다.");

	}
}
