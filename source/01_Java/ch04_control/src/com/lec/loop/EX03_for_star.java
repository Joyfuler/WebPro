package com.lec.loop;
//*
//**
//***
//****
//*****
public class EX03_for_star {
	public static void main(String[] args) {
		for(int i=1 ; i<=5 ; i++) {
			// System.out.println("*****"); // �̷��� �� �ټ����� �ټ��� ���.
			// sysout �κ��� ���������... i�� 1�϶��� 1��, i�� 2�϶��� 2��, i�� 3���϶��� 3��...
			for(int j=1 ; j<=i; j++) {
				// �ٱ� i�� 1~5 �ݺ�, j�� 1~i���� ��. (i�� �ݺ���.)
				System.out.print("*");
			}
			System.out.println(); // ���ุ.. �ݺ� ��ĥ�� �ѹ��� ��������. 
			// * x1 �ݺ��ϰ� ����, * x2 �ݺ��ϰ� ����, *x3 �ݺ��ϰ� ����...
			
	} // for
} // main
} // class