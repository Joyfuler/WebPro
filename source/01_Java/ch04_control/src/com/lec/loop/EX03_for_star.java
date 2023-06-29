package com.lec.loop;
//*
//**
//***
//****
//*****
public class EX03_for_star {
	public static void main(String[] args) {
		for(int i=0
				; i<=5 ; i++) {
			// System.out.println("*****"); // 이러면 별 다섯개가 다섯줄 출력.
			// sysout 부분을 변경해줘야... i가 1일때는 1개, i가 2일때는 2개, i가 3개일때는 3개...
			for(int j=5 ; j>i; j--) {
				System.out.print("*");	
			}
			System.out.println();
				// 바깥 i는 1~5 반복, j는 1~i까지 돔. (i번 반복함.)
//				for (int k=1; k<=i; k++) {
//				System.out.print("*");
			}
			 // 개행만.. 반복 마칠때 한번씩 개행해줌. 
			// * x1 반복하고 개행, * x2 반복하고 개행, *x3 반복하고 개행...
			
	 
} // main
} // class