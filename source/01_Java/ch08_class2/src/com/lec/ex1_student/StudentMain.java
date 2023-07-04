package com.lec.ex1_student;

import java.io.ObjectInputStream.GetField;

public class StudentMain {

	public static void main(String[] args) {
		
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 90, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("마동석", 99, 99, 99);
		
		Student[] students = {s1, s2, s3, s4, s5};
		String [] title = {"이름","국어","영어","수학","총점","평균"};
		//int totKor = 0, totEng=0, totMat=0, tottot=0, totAvg=0;
		 // 5개의 배열 만들기. 국영수총평 5개의 합이 담겨있는 것.
		line();
		System.out.println("\t\t\t     성 적 표");
		line('-');
		for (String t : title) {
			System.out.print("\t" + t);
		}
		System.out.println();
		
		
		line('-');
		int[] total = new int[5];
		for (int idx = 0; idx < students.length; idx++) { // students 배열의 길이만큼
			//System.out.println(students[idx].infoString()); // 일반for문 입력시 students[idx]만 입력하면 주소뜸.뒤에 infostring을 넣자.
			students[idx].print(); // print는 sout이 이미 있으므로 sout을 쓰지 않고 students[idx].print(); 를 사용하면 됨.
			total[0] += students[idx].getKor(); // 학생 1~5까지의 국어점수 합을 total 배열의 첫번째로. (반복문)
			total[1] += students[idx].getEng(); 
			total[2] += students[idx].getMat();
			total[3] += students[idx].getTot(); // 학생 1~5까지의 총점 합을 total 배열의 네번째로. (반복문)
			total[4] += students[idx].getAvg(); // 다섯명의 평균의 합. 
			
			// avg는 double이지만 이 식을 사용하면 알아서 8바이트 double형으로 변환됨.
			// 혹은 total[4] = total[4] + (int) students[idx].getAvg();
		
		}
		
		line('-');
		System.out.print("\t총점");
		for (int tot : total) {
			System.out.printf("\t%d", tot); // 다섯명의 각 과목과 총점, 평균의 합
		}
		
		System.out.print("\n\t평균");
		for (int tot : total) {
			System.out.printf("\t%.2f", (double)tot/students.length); // 위 내용을 학생 수 (5명)만큼 나눔. 소숫점 단위로 변환
																		//이후 학생 번호순으로 반복해 뿌림
			
		
		// idx 0: 국어, idx1: 영어, idx2: 수학, idx3: 총점, idx4: 평균
	
			
		} System.out.println();
			
		
		line();
		
		
		}
	
	private static void line (char c) { // c를 line으로 뿌리기
	System.out.print("\t");
	for (int i = 0; i<50; i++) {
		System.out.print(c); // line('-') 으로 char c를 이미 set 했으므로.
	}
	System.out.println();
	}
	

	private static void line() { // 기본적으로 - 진하고 긴 라인 뿌리기
		for (int i = 0; i<65; i++) {
			System.out.print('■');
		}
		System.out.println();
		
	}
	}
	

