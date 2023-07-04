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
     	// ������ �� ��ȣ�� �켱 ����ֱ�.
		// �⺻ �����ڴ� �־���� �迭�� �����Ͱ� �ֱ� ������ �ǹ̰� ����. �Ʒ��� �־��...
	
	public Student(String name, int kor, int eng, int mat) {

		studentNo = ++number; // �Ʒ� return�ϴ� ���� studentNo�� �� ����! main���� �迭 Ȯ�ν� �򰥸��� ����
		// ���� ���� int�� �̹� studentNo�� ����Ǿ����Ƿ� int�� ���� �� �ʿ䰡 ����.
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = (int) (tot / 3.0 + 0.5); //�ݿø�. 0.5 �̻��� ��� 1.~ �� �Ǹ鼭 ������ int ������ ������.

	}

	public String infoString() {
		return String.format("%d\t %s\t %d\t %d\t %d\t %d\t %d\t", studentNo, name, kor, eng, mat, tot, avg);
		//���Ͻÿ��� �迭�� �������� �ʾҴ� ���� ��ȯ��
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
