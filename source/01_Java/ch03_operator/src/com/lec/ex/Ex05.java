package com.lec.ex;
// ���׿����� (���ǽ�) ?    (a==b) ?  ������ true�� ��� ���� �� : ������ false�� ��� ���� ��
public class Ex05 {
	public static void main(String[] args) {
		int h = 100;
//		String result = (h%2 == 0)? "¦���Դϴ�":"Ȧ���Դϴ�"; // h�� 2�� ���� �������� 0�� true��� ¦��, false��� Ȧ���� ǥ��. 
		String result = (h%2 == 0)? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		System.out.println(result); // ¦���Ӵϴ�
		if (h%2 == 0) { // if else�� ����ص� �����ϰ� ��� ����. �Ϲ������δ� ������ �� ���� ���¸��
			System.out.println("¦���Դϴ�.");
		} else {
			System.out.println("Ȧ���Դϴ�.");
				
			}
		}
		
	}


