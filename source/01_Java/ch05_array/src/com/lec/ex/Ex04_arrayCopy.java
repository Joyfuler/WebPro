package com.lec.ex;
// �迭 ���� (���� �����ؼ� �۵��ϰ�, �����͸� �����ϰ� �������� ��)
public class Ex04_arrayCopy {
	public static void main(String[] args) {
		
	
	int [] score = {100,20,30,40,50};
	// int [] s = score; X... ���� �ּ��̹Ƿ� �����ؼ� �۵�x
	int [] s = new int [score.length]; // score�� ���̸� �״�� ������.
		
		for(int i=0; i<score.length; i++) { // s[0] = score[0] ���� ������ ��ȣ���� �ݺ��ϴ� ����.
			s[i] = score [i]; // score�� �迭 �����͸� �״�� ������. �ּ� �������°��� �ƴ�
			
		}
		s[0]= 99; // s�迭�� ù��°�� 99�� �ٲ㵵 score[0]�� �״�� 100��. 
		for (int i=0; i<score.length; i++) {
			// System.out.printf("score[%d] = %d \t s[%d] = %d\n", i, score[i], i, s[i]);
		
			
			// �̹� �ִ� �ڹ��ڵ带 ������ ���� ��� - System.arraycopy �̿�
			// System.arraycopy(src, srcPos, dest, destPos, length); // src = score / srcPos(���°�ε�������?) =0 (ó������) 
			// dest = s, destPos = 0, ���� = score.length
			System.arraycopy(score, 0, s, 0, score.length);
			s[1]= 97; // s1 ������ �ٲ㵵 ���������� score1�� �ٲ�������.
			System.out.printf("score[%d] = %d \t s[%d] = %d \n", i, score[i], i, s[i]);
			
		}
		}
		
}
