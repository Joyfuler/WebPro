package com.lec.loop;
 // while ���� �̿��� �����հ��
public class Ex08_while {
	public static void main(String[] args) {
		// for�� ����ϴ� ����� �����հ��
		
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			total += i;
			System.out.printf("i�� %d�� ������ �������� %d�̴�\n", i, total);
			
		}
		System.out.println("");
		int tot = 0;
		int i = 1;
		while (i <= 10) { 
		tot += i;
		System.out.printf("i�� %d�� �������� �������� %d�̴�. \n", i, tot);
		i++;
		}
		
		//int i = ;
		//while (i <= 10) { i++;
		
		}
	}

