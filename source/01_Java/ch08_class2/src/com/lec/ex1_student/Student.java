package com.lec.ex1_student;
// 데이터 (이름, 국영수 점수, 총점, 평균)

// Student s = new Student("정우성, 100,100); 혹은
// Student s = new Student(); s.name ~ getset으로 사용할수도. (다만 불편)

public class Student {
	private String name;
	private int kor, eng, mat, tot;
	private double avg;

	public Student() { // 디폴트 생성자
	}
	
	
	public Student(String name, int kor, int eng, int mat) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0; // 소숫점까지 구하기 위해서는 3이 아닌 3.0으로 나눈다는거 주의!

	}
	
	public void print() {
		System.out.printf("\t%s \t%d \t%d \t%d \t%d \t%.2f\n",
				         name, kor, eng, mat, tot, avg);
				
	}
	
	public String infoString() {
		// return "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg;
		// 일일히 손노가다하려면 힘드니...
		
		return String.format("\t%s \t%d \t%d \t%d \t%d \t%.2f",
				         name, kor, eng, mat, tot, avg);
	}
	
	// getter만 만들기.

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}

	public int getTot() {
		return tot;
	}

	public double getAvg() {
		return avg;
	}

}
