package com.lec.loopQuiz;

public class rewarewar {
	public static void main(String[] args){
		int i = 10; // ��������, �ʱ�ȭ
		int[] iArr = {10,20,30,40,50};//��迭����,�ʱ�ȭ
		for(i=0 ; i<iArr.length ; i++)
			System.out.print(iArr[i]);
		int[] jArr = new int[5];//��迭������޸��Ҵ� 
		jArr[0] = 100;
		jArr[1] = 200;
		jArr[2] = 300;
		jArr[3] = 400; //jArr[4]=X
		for(i=0 ; i<jArr.length ; i++)
			System.out.println(jArr[i]);
		int[] score; //�麯������
		score = new int[3]; //�޸�Ȯ��
		score[0] = 1000; score[1]=2000; score[2]=11; //�� �Ҵ�
		//score[3] = 99; // runtime error
		for(i=0 ; i<score.length ; i++)
			System.out.println(score[i]);
	}

	
}
