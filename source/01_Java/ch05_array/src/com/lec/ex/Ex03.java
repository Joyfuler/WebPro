package com.lec.ex;

public class Ex03 {
	public static void main(String[] args) {
		int i = 10;
		int j = 1;
		j = 99; // j�� 1�� ���ư��� 99�� ���� ��.
		System.out.println(i+ "\t" +j);
// �迭�� ī���ϰ� ������? ��ġ j�� 99���� �ȹٲ�� ��ó��..
		
		int[] score = {10,20,30,40,50};
		int[] s = score; // s��� �迭�� score�� ī���� ��.
		for (int idx = 0; idx <score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			// score[0] = 10  s[0]= 10 �������� ��µ�. 
		}
		s[0] = 99;
		System.out.println("s[0]�� ������ �� --");
		for (int idx = 0; idx <score.length; idx++) {
			System.out.printf("score[%d] = %d \t s[%d] = %d\n", idx, score[idx], idx, s[idx]);
			// score[0] = 10  s[0]= 10 �������� ��µ�.
			// ��� s[0]�� 99�� �ٲ�µ� score[0]���� �ڵ����� 99�� ����Ǵ� �����...
			// >> s�� ��ü �����̹Ƿ� �ش� ���� ���� �������� ���� �ƴ� �������� ������. 
			// s[0]�� ��ġ�� ��� s[0]�� �迭�� �ٲ�� ���� �ƴ϶� ���� �����Ͱ� ����Ǵ� ��. ���� score ���� ����Ǵ� ����� ��.
			// s[n]�� ���� �����Ϸ���...?
			
		
	}
}
}