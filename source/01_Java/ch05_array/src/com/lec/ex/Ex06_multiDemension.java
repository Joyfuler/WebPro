package com.lec.ex;
// 다차원배열... 실무에서는 사용할 일이 거의 x
public class Ex06_multiDemension {
	public static void main(String[] args) {
		// 기존 1차원 배열
		int [] arr = {1,2,3}; //
		System.out.println(arr[2]); // 한 배열을 출력할 때의 방법 : 3이 출력.
		System.out.println("............");
		
		
		int [][] test = {{1,2,3},
						{4,5,6}}; // 2차원 배열 입력 시에는 괄호를 두개 넣고 한 줄이 끝날 때 괄호를 닫자.
		System.out.println(test[0][1]);
		// 다차원 출력하는 방법
		for(int i=0; i<test.length; i++) { // y축. 세로길이는 0,1..
			for(int j=0; j< test[i].length; j++) { // test[1]의 길이는 3이므로
				System.out.printf("test[%d][%d] = %d \t", i,j,test[i][j]);
		}
		}
		// 배열을 지정해 주는 경우
		int [][] test2 = new int [2][3];
		test2[1][0]=200; // ...이런 식으로
		}
		}
	

