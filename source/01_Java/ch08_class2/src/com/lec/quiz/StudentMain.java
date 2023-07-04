package com.lec.quiz;

public class StudentMain {

	public static void main(String[] args) {

		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90);
		// 배열에는 숫자를 넣지 않았으나 return할 때 맨 앞에 StudentNo가 나오도록 설정했으므로..
		Student[] students = { s1, s2, s3, s4, s5 };
		String[] title = { "번호\t", "이름\t", "국어\t", "영어\t", "수학\t", "총점\t", "평균" };

		Line();
		System.out.println("\t\t\t\t 성적표");
		Line('-');
				
		for (int idx = 0; idx < title.length; idx++) {
			System.out.print(title[idx]);
		}
		System.out.println();

		Line('-');
		
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].infoString());
		}
		// 각 합을 만들기 위해 total 배열을 생성.
		int total[] = new int[5];
		for (int i = 0; i < students.length; i++) {
			total[0] += students[i].getKor();
			total[1] += students[i].getEng();
			total[2] += students[i].getMat();
			total[3] += students[i].getTot();
			total[4] += students[i].getAvg();
		}
		Line('-');
		

		// 총점을 위한 배열 만들기
		System.out.print("\t 총점\t");
		for (int i = 0; i < total.length; i++) {
			System.out.print(total[i] + "\t");
		}

		System.out.println();
		System.out.print("\t 평균\t");
		for (int tot : total) {
			System.out.print(tot / students.length + "\t");
		} 
		System.out.println();
		Line();

	}

	public static void Line() {
		for (int i = 0; i < 65; i++) {
			System.out.print('■');

		}
		System.out.println();

	}

	public static void Line(char c) {
		for (int i = 0; i < 65; i++) {
			System.out.print('-');

		}
		System.out.println();

	}

}
