//package co.dev;
//
//import java.util.ArrayList;
//
//public class StudExample {
//	public static void main(String[] args) {
//		Student stud = new Student(101, "홍길동", 100);
//		String name1 = stud.getStudName();
//		int score1 = stud.getScore();
//		int no1 = stud.getStudNo();
//
//		ArrayList<Student> list = new ArrayList<Student>();
//		list.add(stud);
//		list.add(new Student(102, "김현수", 88));
//		list.add(0, new Student(103, "박문수", 78));
//
//		Student hong = new Student(201, "홍수환", 90);
//
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getStudName().equals("김현수")) {
//				list.add(i, hong);
//
//				break;
//			}
//		}
//
//		// 출력
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getStudName());
//		}
//		// 학번기준으로 정렬.
////		ArrayList<Student> sortAry = new ArrayList<Student>();
////		for (int i = 0; i < list.size(); i++) {
////			for (int j = 0; j < i; j++) {
////				if (list.get(i).getStudNo() > list.get(j).getStudNo()) {
////					 sortAry = list.get(j);
////					sortAry.get(j) = list.get(i);
//
////				}
////
////			}
//		}
//
//	}
//}
