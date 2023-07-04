package com.lec.ex1_student;
// ������ (�̸�, ������ ����, ����, ���)

// Student s = new Student("���켺, 100,100); Ȥ��
// Student s = new Student(); s.name ~ getset���� ����Ҽ���. (�ٸ� ����)

public class Student {
	private String name;
	private int kor, eng, mat, tot;
	private double avg;

	public Student() { // ����Ʈ ������
	}
	
	
	public Student(String name, int kor, int eng, int mat) {

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = tot / 3.0; // �Ҽ������� ���ϱ� ���ؼ��� 3�� �ƴ� 3.0���� �����ٴ°� ����!

	}
	
	public void print() {
		System.out.printf("\t%s \t%d \t%d \t%d \t%d \t%.2f\n",
				         name, kor, eng, mat, tot, avg);
				
	}
	
	public String infoString() {
		// return "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + avg;
		// ������ �ճ밡���Ϸ��� �����...
		
		return String.format("\t%s \t%d \t%d \t%d \t%d \t%.2f",
				         name, kor, eng, mat, tot, avg);
	}
	
	// getter�� �����.

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
