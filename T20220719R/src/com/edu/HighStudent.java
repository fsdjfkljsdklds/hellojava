package com.edu;

public class HighStudent extends Student {
//	고등학생정보 : 담임교사, 학년 정보 추가.
	private String teacher;
	private String grade;

	// 생성자.
	public HighStudent(String studNo, String studName, int score, String teacher, String grade) {
		super(studNo, studName, score);
		this.teacher = teacher;
		this.grade = grade;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	// toString()

	@Override
	public String toString() {
		return "HighStudent [학생번호: " + getStudNo() + ", 이름: " + getStudName() + ", 점수: " + getScore()
				+ ", 담임교사: " + teacher + ", 학년: " + grade + "]";
	}

}
