package ex1_tryCatch;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i,j ; // ����ڿ��� �Է¹��� ���� ����
		System.out.print("ù��° ������ (��Ģ���� ����� ����)? ");
		i = scanner.nextInt();
		System.out.print("�� ��° ������ (��Ģ���� ����� ����)? ");
		j = scanner.nextInt();
		try { // ���� �� ���� ������ ���� ����. try - catch
		System.out.println(" i / j = " + (i / j)); // 0���� ���� ��� ���ܰ� �߻��� �� ����. �ݵ�� x... �Ϻ� ��Ȳ����
	
		} catch(ArithmeticException e) { // try���� ���� �߻� x�� catch�� �Ѿ. try���� ���ܰ� �߻��ϸ� catch�� ��.
			// cat ���� �ش� ������ + ������.
			// System.out.println(e.getMessage()); // �ش� ������ �޽����� ���.
			e.printStackTrace();// ���� �޽����� �ſ� �ڼ��ϰ� ����ϱ� ����. �ش� ������ �� ��° �ٿ� �ִ����� Ȯ���� �� �ִٴ� ����.
			// ���α׷��� ������� �ʰ�, ���� �߻��� �ִ� �޽����� ��� ����� �� ���ĸ� �����ϰ� ����
		}
		System.out.println(" i + j = " + (i + j));
		System.out.println(" i - j = " + (i - j));
		System.out.println(" i * j = " + (i * j));
		
	
		System.out.println("DONE");
		scanner.close();
		
	
	}
}
