package com.lec.ch04.ex_auto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;


public class StudentInfo {

// Student class를 의존하는 StudentInfo
	@Autowired // 생성자와 필드, setter 주입
	private Student student;
	@Autowired
	public StudentInfo(Student student) {
	this.student = student;
}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
