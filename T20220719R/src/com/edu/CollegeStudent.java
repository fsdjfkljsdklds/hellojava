package com.edu;

public class CollegeStudent extends Student {
//	대학생정보 : 담당교수, 전공과목 정보 추가.
	private String prof;
	private String major;

	// 생성자.
	public CollegeStudent(String studNo, String studName, int score, String prof, String major) {
		super(studNo, studName, score);
		this.prof = prof;
		this.major = major;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	// toString()

	@Override
	public String toString() {
		return "CollegeStudent [학생번호: " + getStudNo() + ", 이름: " + getStudName() + ", 점수: " + getScore() +", 담당교수: " + prof + ", 전공과목: " + major + "]";
	}

}
