package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int i = 10;
		int j = 1;
		j = 99; // j에 1이 날아가고 99가 새로 들어감.
		System.out.println(i+ "\t" +j);
// 배열을 카피하고 싶을때? 마치 j가 99에서 안바뀌는 것처럼..
		
		int[] score = {10,20,30,40,50};
		int[] s = score; // s라는 배열은 score를 카피한 것.
		for (int idx = 0; idx <score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			// score[0] = 10  s[0]= 10 형식으로 출력됨. 
		}
		s[0] = 99;
		System.out.println("s[0]만 변경한 후 --");
		for (int idx = 0; idx <score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			// score[0] = 10  s[0]= 10 형식으로 출력됨.
			// 결과 s[0]만 99로 바꿨는데 score[0]역시 자동으로 99로 변경되는 결과가...
			// >> s는 객체 변수이므로 해당 값을 직접 가져오는 것이 아닌 번지수를 가져옴. 
			// s[0]을 고치는 경우 s[0]의 배열이 바뀌는 것이 아니라 원본 데이터가 변경되는 것. 따라서 score 역시 변경되는 결과가 됨.
			// s[n]만 따로 변경하려면...?
			
		
	}
}
}