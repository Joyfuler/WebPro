package com.lec.ex;
// �������迭... �ǹ������� ����� ���� ���� x
public class Ex06_multiDemension {
	public static void main(String[] args) {
		// ���� 1���� �迭
		int [] arr = {1,2,3}; //
		System.out.println(arr[2]); // �� �迭�� ����� ���� ��� : 3�� ���.
		System.out.println("............");
		
		
		int [][] test = {{1,2,3},
						{4,5,6}}; // 2���� �迭 �Է� �ÿ��� ��ȣ�� �ΰ� �ְ� �� ���� ���� �� ��ȣ�� ����.
		System.out.println(test[0][1]);
		// ������ ����ϴ� ���
		for(int i=0; i<test.length; i++) { // y��. ���α��̴� 0,1..
			for(int j=0; j< test[i].length; j++) { // test[1]�� ���̴� 3�̹Ƿ�
				System.out.printf("test[%d][%d] = %d \t", i,j,test[i][j]);
		}
		}
		// �迭�� ������ �ִ� ���
		int [][] test2 = new int [2][3];
		test2[1][0]=200; // ...�̷� ������
		}
		}
	

