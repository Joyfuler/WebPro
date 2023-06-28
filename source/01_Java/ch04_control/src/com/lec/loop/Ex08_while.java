package com.lec.loop;
 // while 문을 이용한 누적합계산
public class Ex08_while {
	public static void main(String[] args) {
		// for를 사용하는 경우의 누적합계산
		
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			total += i;
			System.out.printf("i가 %d일 때까지 누적합은 %d이다\n", i, total);
			
		}
		System.out.println("");
		int tot = 0;
		int i = 1;
		while (i <= 10) { 
		tot += i;
		System.out.printf("i가 %d일 때까지의 누적합은 %d이다. \n", i, tot);
		i++;
		}
		
		//int i = ;
		//while (i <= 10) { i++;
		
		}
	}

