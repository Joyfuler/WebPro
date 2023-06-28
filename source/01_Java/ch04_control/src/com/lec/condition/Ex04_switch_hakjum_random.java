package com.lec.condition;

// 랜덤 점수의 학점 출력 
public class Ex04_switch_hakjum_random {
	public static void main(String[] args) {
		// 난수 발생
		// System.out.println((int)(Math.random() * 101)); // (0에서 1사이의 실수(소수)가 난수로 표시 >0, <=1) * 101하면 0이상 101 미만의 난수 발생 (100은 포함해야 하므로 101 곱하는듯)
		 // (int)(Math.random() * 101 하는 경우 앞 math.random이 먼저 정수 처리 (0) 되므로 x101을 해도 0이 됨. 따라서 (int)를 맨 앞에 둘것.
		int score = (int)(Math.random() * 101); // int score = (int)(Math.random() * 101);
		System.out.println("점수 : " + score);
		// 학점 출력
		switch (score / 10) { 
		case 10: case 9:
			System.out.println("A학점"); break;
		case 8:
			System.out.println("B학점"); break;
		case 7:
			System.out.println("C학점"); break;
		case 6:
			System.out.println("D학점"); break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			System.out.println("F학점"); break; // 컴퓨터는 말을 잘 들으므로 101이나 기타 수를 입력하지 않으므로 default가 필요하지 않음		
		}
		
		/*
		 * if ((score >= 90) && (score < 100)) { // 2개를 만족. 괄호로 우선순위 설정가능. (안해도 되긴함)
		 * System.out.println("A학점"); } else if (score >= 80 && score < 90) { // 100보다
		 * 높은거 쓸 경우 오류남. score < 90을 넣어줘야 System.out.println("B학점"); } else if (score >=
		 * 70 && score < 80) { System.out.println("C학점"); } else if (score >= 60 &&
		 * score < 70) { System.out.println("D학점"); } else if (score >= 0 && score < 60)
		 * { System.out.println("F학점"); } else { System.out.println("유효하지 않은 점수");
		 * 
		 * } // else
		 */
		
	} //main
} // class
