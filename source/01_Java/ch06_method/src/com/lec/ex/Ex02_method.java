package com.lec.ex;

public class Ex02_method {
 // parameter (=�Ű�����) -> �ٲ�� Ư�� ��.. �ַ� from, to�� �����) �� �޾� from���� to������ �������� return �ؾ���. (ȣ���ڿ��� ��ȯ�ϴ� ��)
 // ����������: private (�� ���Ͽ����� �� ����), public (�ٸ� ���Ͽ����� �� ��)
//  ����Ÿ�� : ������ ���� Ÿ����?
	private static int sum (int from, int to) { // �ڡ� from���� to���� ����. 
	 int tot = 0; // ��������
	 	for (int i = from; i <= to; i++) {
	 		tot += i;
	 	}
	 	return tot; // tot ���� main�� ��ȯ���� ����
	 	
	
	}

	// �з����� (�Ű�����, ���� ( value)�� �޾� ¦, Ȧ�� ���θ� ���ڿ��� return �ϴ� �޼ҵ�
	// ¦���Դϴ�. Ȧ���Դϴ�. ���� return�ϹǷ� return Ÿ���� String
	private static String evenOdd(int value) { // value���� ���� �� ¦,Ȧ�� ����
		String result = value % 2 == 0 ? "¦���Դϴ�." : "Ȧ���Դϴ�."; //result ���� ����ϴ� ���� 
		return result; // result�� ��ȯ. ��ȯ���� �ݵ�� ���� ��.
	}
	
	public static void main(String[] args) { // void�� ���ϰ��� ���� ���. main �Լ������� return ��� ������.
		//int tot = sum(1,10); // sum �޼ҵ忡 �ִ� tot ������ 2���� ���� ����.
		int tot = sum(1,50); // sum �޼ҵ��� from�� 1, to�� 50
		System.out.println("1���� 50���� ������ ����" + tot);
		System.out.println("����" + evenOdd(tot));
		
		tot = sum (50,151);
		System.out.println( "50���� 151���� ������ ����" + tot);
		System.out.println(evenOdd(tot)); //�� �������� tot= 50���� 151�� �� 10251�� �Ǿ���. ���� evenodd(10251)�� ��. 
		
		
		
	}
		
	}
 
