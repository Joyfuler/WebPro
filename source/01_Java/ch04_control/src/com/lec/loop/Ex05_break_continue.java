package com.lec.loop;
// break와 continue 사용
public class Ex05_break_continue {
	public static void main(String[] args) {
		for (int i= 1; i <= 10; i++) {
			if (i ==3) {
				continue; // i가 3이 되었을 때 맨 위로 올라감. (증감식이 있는 곳으로) --> 결과 3이 되는 순간 3이 출력되지 않고 조건식으로 돌아가 4부터 다시 출력됨
				// break; // i가 3이 되면서 break되어 반복문을 빠져나옴. 결과 1과 2만 출력되고 괄호밖으로 나감
			}
			System.out.println(i);
		}
		System.out.println();
	} 
}
