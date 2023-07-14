package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1; // ����ڿ��� �Է¹��� ���� ����. ��, ����ó���� int ��꿡�� ������ ������ �߻��� �� ������ �ϴ� 1�� �ʱ�ȭ..

		do {
			try { // ����try�� ���ϰ�, catch { } catch�� ������.
				System.out.print("ù��° ������ (��Ģ���� ����� ����)? ");
				i = scanner.nextInt();
				break;
				// ����� ������ �Է��� ��� ������ ���� �� �ֵ���.
			} catch (InputMismatchException e) {
				System.out.println("���� ���ڸ� ���� ������.");
				scanner.nextLine(); // �������� ���� �ƴ϶�, �����ִ� ���۸� ����� ����. (i�� a���� ������ ���ۿ� ���� ���ѹݺ��� �ϹǷ�)
				// ������ �����ϰ� �����߻��ÿ��� ������ �ٲ�����.
			}

		} while (true);
		System.out.print("�� ��° ������ (��Ģ���� ����� ����)? ");

		try {

			j = scanner.nextInt();
			 // ���ܰ� �߻��߱� ����...

		} catch (ArithmeticException e) { // try���� ���� �߻� x�� catch�� �Ѿ. try���� ���ܰ� �߻��ϸ� catch�� ��.
			// cat ���� �ش� ������ + ������.
			System.out.println(e.getMessage()); // �ش� ������ �޽����� ���.
			e.printStackTrace();// ���� �޽����� �ſ� �ڼ��ϰ� ����ϱ� ����. �ش� ������ �� ��° �ٿ� �ִ����� Ȯ���� �� �ִٴ� ����.
			// ���α׷��� ������� �ʰ�, ���� �߻��� �ִ� �޽����� ��� ����� �� ���ĸ� �����ϰ� ����

		} catch (Exception e) {
			System.out.println(e.getMessage()); // ���� �޽����� ����.
			System.out.println("�� ���� ������ �߸� �Է��Ͻø� ������ 1�� ó���մϴ�.");

			// ���� �� ���� ������ ���� ����. try - catch
			// 0���� ���� ��� ���ܰ� �߻��� �� ����. �ݵ�� x... �Ϻ� ��Ȳ����

			// catch (Exception e) Ȥ�ø� ��翹��ó���޽���. ���� �θ𿹿ܴ� �ǵ��� �Ʒ��� �Ѱ�..

		}
		System.out.println(" i / j = " + (i / j));
		System.out.println(" i + j = " + (i + j));
		System.out.println(" i - j = " + (i - j));
		System.out.println(" i * j = " + (i * j));

		System.out.println("DONE");
		scanner.close();

	}
}
