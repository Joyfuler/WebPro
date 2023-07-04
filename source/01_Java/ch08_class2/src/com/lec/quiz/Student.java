package com.lec.quiz;

public class Student {
	private int studentNo; 
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private String name;
	private int avg; 
	public static int number = 0;
     	// 공유가 될 번호를 우선 집어넣기.
		// 기본 생성자는 넣어봐야 배열에 데이터가 있기 때문에 의미가 없음. 아래에 넣어야...
	
	public Student(String name, int kor, int eng, int mat) {

		studentNo = ++number; // 아래 return하는 값에 studentNo가 들어가 있음! main에서 배열 확인시 헷갈리지 말것
		// 또한 위에 int로 이미 studentNo가 선언되었으므로 int가 새로 들어갈 필요가 없음.
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = (int) (tot / 3.0 + 0.5); //반올림. 0.5 이상인 경우 1.~ 이 되면서 버리면 int 정수가 가능함.

	}

	public String infoString() {
		return String.format("%d\t %s\t %d\t %d\t %d\t %d\t %d\t", studentNo, name, kor, eng, mat, tot, avg);
		//리턴시에는 배열에 설정하지 않았던 것이 반환됨
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

}
