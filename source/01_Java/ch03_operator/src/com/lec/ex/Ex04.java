package com.lec.ex;
//�� ������ : &&(and) ||(or) & | ? ��
public class Ex04 {
	public static void main(String[] args) {
		
		int i=1, j=10, h=10;
		System.out.println("&&(AND) : (i<j) && (++j>h) ��" + ((i<j) && (++j>h))); // i<j = 1<10 // ++j>h �� 11>1�̹Ƿ� ��� true.
		//or���� ��� true�̹Ƿ� ����� true�� ���
		System.out.println("j=" + j);
		System.out.println("&&(AND) : (i>j) && (++j>h) ��" + ((i>j) && (++j>h)));
		System.out.println("j=" + j);
		
		// ||�������� ��� ������ true�̸� ������ ���� ������� true�� ��µ�. (�Ѱ��� true�� �����ϸ� true)
		System.out.println("||(OR) : (i>j) || (++j>h) �� " + ((i>j) || (++j>h) )); // i>j�� false, ++j>h�� true�̹Ƿ� true
		System.out.println("||(OR) : (i<j) || (++j>h) ��" + ((i<j) || (++j>h))); // i<j�� true, ++j>h �� true�̹Ƿ� true
		System.out.println("||(OR) : (i<j) || (++j>h) ��" + ((i>j) || (++j<h))); // i>j�� false, ++j<h�� false�̹Ƿ� false
		
		// & | ����? 
		
		
	}
}
