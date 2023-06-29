package com.lec.ex;
// 배열 복제 (서로 독립해서 작동하고, 데이터만 동일하게 가져오는 것)
public class Ex04_arrayCopy {
	public static void main(String[] args) {
		
	
	int [] score = {100,20,30,40,50};
	// int [] s = score; X... 같은 주소이므로 독립해서 작동x
	int [] s = new int [score.length]; // score의 길이를 그대로 가져옴.
		
		for(int i=0; i<score.length; i++) { // s[0] = score[0] 부터 마지막 번호까지 반복하는 문장.
			s[i] = score [i]; // score의 배열 데이터를 그대로 가져옴. 주소 가져오는것이 아님
			
		}
		s[0]= 99; // s배열의 첫번째를 99로 바꿔도 score[0]은 그대로 100임. 
		for (int i=0; i<score.length; i++) {
			// System.out.printf("score[%d] = %d \t s[%d] = %d\n", i, score[i], i, s[i]);
		
			
			// 이미 있는 자바코드를 가져다 쓰는 방법 - System.arraycopy 이용
			// System.arraycopy(src, srcPos, dest, destPos, length); // src = score / srcPos(몇번째인덱스부터?) =0 (처음부터) 
			// dest = s, destPos = 0, 길이 = score.length
			System.arraycopy(score, 0, s, 0, score.length);
			s[1]= 97; // s1 가격을 바꿔도 마찬가지로 score1은 바뀌지않음.
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score[i], i, s[i]);
			
		}
		}
		
}
