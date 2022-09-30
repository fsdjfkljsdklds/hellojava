package co.edu;

public class AppMain2 {
	public static void main(String[] args) {

		Student.staticMethod();
		
		Math.random();
		Math.round(.5);
		
		Student s1 = new Student();
		// s1.staticMethod(); // error 아닌데 warning.

		s1.setNum("21620326");
		s1.setName("김지한");
		s1.setAge(26);
		s1.setMajor("식품경제외식");
		System.out.println(s1.getAge()); // String =null 초기값출력.
		System.out.println(s1.getNum()); // int = 초기값 0;
		System.out.println(s1.getMajor());
		System.out.println(s1.getName());
		System.out.println(s1.showInfo());

		Student s2 = new Student();

		s2.setNum("21320326");
		s2.setName("김수한");
		s2.setAge(28);
		s2.setMajor("경영학과");
		System.out.println(s2.showInfo());

		String[] hob = { "독서", "자전거" };
		s1.setHobbies(hob);
		s1.addHobby("음악듣기");
		System.out.println(s1.getHobb());

		Student s3 = new Student();
		System.out.println(s3.getName());

		Student s4 = new Student("111-234", "주소영");
		System.out.println(s4.showInfo());

		Student s5 = new Student("111-222", "송지은", "역사학과");
		System.out.println(s5.showInfo());

		Student s6 = new Student("111-333", "김지한", "경영학과", 26);
		System.out.println(s6.showInfo());

	}

}
