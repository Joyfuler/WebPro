package com.lec.ex1_tryCatch;

import java.text.Format;

public class Ex03_finally {
	public static void main(String[] args) {

		int[] arr = { 0, 1, 2 };
		for (int idx = 0; idx <= arr.length; idx++) {
			try {
				System.out.println("arr[" + idx + "] = " + arr[idx]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("���� �޽��� : " + e.getMessage());
			} finally { // ������ try���� ������ �۾�...? �������� ���� ���. 
				System.out.println("try�� ���� �Ŀ���, catch�� ���� �Ŀ��� �׻� ����Ǵ� ��.");
			} // try + catch + finally (try��)
			System.out.println("----------------------------------------");

		}
	}
}
