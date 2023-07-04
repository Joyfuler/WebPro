package com.lec.quiz;

public class Prac {
	private int no;
	private static int count = 1;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int avg;
	public Prac(String name, int kor, int eng, int mat) {
		super();
		no = count++;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		avg = (avg / 3);
	}
	
	public void infoPrint() {
		System.out.printf("%d\t %s\t %d\t %d\t %d\t %d\t %d\t", no, name, kor, eng, mat, tot, avg);
	}
	
	
	
}
