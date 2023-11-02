package com.lec.ch02.ex3_student;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentPrint {
	private Student student;	
	public void print() {
		if (student != null) {
		System.out.println("---------------------");
		System.out.println("이름 :" + student.getName());
		System.out.println("나이 :" + student.getAge());
		System.out.println("학년 :" + student.getGradeNum());
		System.out.println("반: " + student.getClassNum());
		} else {
			System.out.println("의존하는 Student형 객체가 들어오지 않음");
			//student는 외부에서 주입하지 않는 경우 null이 되며 nullpointerException이 발생할 수 있음.
		}	
	}
}