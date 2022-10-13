package com.edu;

import java.util.List;

public interface StudentService {
	// 추가
	public void addStudent(Student student);

	// 목록
	public List<Student> studentList();

	// 수정
	public void modStudent(String studNo, int score);

}
