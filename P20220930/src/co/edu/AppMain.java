package co.edu;

//하나의 실행클래스와 여러개의 라이브러리클래스.
public class AppMain {
	public static void main(String[] args) {
		// Object -> Class -> Instance
//		Person kim = new Person(); // 인스턴스 생성.
//		kim.name = "김민기";
//		kim.age = 20;
//		kim.sleep();
//		kim.eat("사과");
//		kim.run();
//		
//		Person lee = new Person();
//		lee.name = "이순신";
//		lee.age = 25;
//		lee.sleep();
//		lee.eat("피자");
//		System.out.println(kim);
//		System.out.println(lee);

		Student stud1 = new Student();
//		stud1.name = "김지한";
		stud1.setName("김지한");
//		stud1.major = "식품경제외식학과";
		stud1.setMajor("21620326");
//		stud1.num = "21620326";
		stud1.setNum("21620326");
		System.out.println(stud1.getName());
		System.out.println(stud1.getMajor());
		System.out.println(stud1.getNum());
		stud1.game();
		stud1.study();
		stud1.sleep();

		Student stud2 = new Student();
//		stud2.name = "김수한";
		stud2.setName("김수한");
//		stud2.major = "경영학과";
		stud2.setMajor("경영학과");
//		stud2.num = "21320326";
		stud2.setNum("21320326");
		stud2.game();
		stud2.study();
		stud2.sleep();

		Student stud3 = new Student();

		Student[] students;
		students = new Student[] { stud1, stud2, stud3 };
		for (Student stud : students) {
			System.out.println("학번: " + stud.getNum() + ", 학생이름:" + stud.getName());
		}

		// 상속.
		WorkMan wman = new WorkMan();
		wman.name = "직장인";
		wman.age = 30;
		wman.sleep();
		wman.run();
		wman.eat("김밥");

		StudMan sman = new StudMan();
		sman.school = "고등학교";
		sman.height = 164.5;

	}
}
