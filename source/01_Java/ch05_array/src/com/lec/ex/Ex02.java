package com.lec.ex;
// �Ϲ� for��  vs Ȯ��for�� (Array, ArrayList)
public class Ex02 {
	public static void main(String[] args) {
		double [] arr = {1.1, 2.2, 3.3}; // double�� ��� {0.0, 0.0, 0.0} ���� �����. (int�� {0,0,0})
		// �Ϲ� for�� (�ε����� ���� ���� ���)
		for (int idx = 0; idx < arr.length; idx++) {
			System.out.printf("arr[%d] = %.1f\t", idx, arr[idx]); // 0.0�� ����ϱ� ���� %d��� %f���� ����. (�Ҽ��� ù°�ڸ����� %.1f)
			System.out.println();
		}
			
		// Ȯ�� for�� (�迭�� ���)
		for (double a : arr) { // foreach ����. a��� �ӽ� ������ ���� �� arr�� ī���� ��.
			// index�� �ʿ� ���� ��쿣 foreach�� �̿��� ����ϴ� ���� ����.
			System.out.println(a + " "); // sysout (a[0])���δ� ��� ����.
						
		}	
		// �迭 ���� ����. ��� ���� 10% �λ��� ���ְ� �ʹٸ�?
		// arr[0] = arr[0] * 1.1; --> arr[0] *= 1.1;
		
		double [] arr2 = {999.0, 987.0, 920.0}; // �ش� �迭�� ��� ���ϱ� 10%�� �ϰ� ���� ���
		for (int idx2 =0; idx2 < arr2.length; idx2++) {
			arr2[idx2] *= 1.1;
			}
		for (double d : arr2) {
			System.out.printf( "%.1f \t", d);
		}
		// Ȥ�� Ȯ��for���� �̿��� �λ��� ���� ����.
		for (double b : arr2) { // 999.0, 987.0, 920.0
			b *= 1.1; // b�� 10%�� �����ָ� ����Ǵ���?
			System.out.printf( "%.1f \t", b); // Ȯ�� for���� �̿��� �� ������ �Ұ���.
                                            		//�迭�� ������ �ӽ� ������ ����Ǵ� ���̹Ƿ�..
		}
		}
	}


