package com.lec.quiz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;


// Writer�� 2����Ʈ�̹Ƿ� String. ���� byte�迭�� �ٲ��ִ� getbytes() �� ���� �ʰ� �׳� tostring()�� �ص� ����� ������.
public class MemberTestMain_writer {
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		Scanner scanner = new Scanner(System.in);
		String name, tel, address, date;
		Date birthday;
		Writer writer = null;
		while (true) {
			System.out.println("ȸ�� ������ �����ϰڽ��ϱ�? (Y/N) - N �Է½� ȸ�� ����Ʈ�� ����մϴ� : ");
			String answer = scanner.nextLine().trim();
			if (answer.equalsIgnoreCase("n"))
				break;
			if (answer.equalsIgnoreCase("y"))
				System.out.println("����� �̸��� �Է����ּ���. : ");
			else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���");
				continue;
			}
			name = scanner.nextLine();
			System.out.println("����� ��ȭ��ȣ�� �Է����ּ���. : ");
			tel = scanner.nextLine().trim();
			System.out.println("����� �ּҸ� �Է����ּ��� : ");
			address = scanner.nextLine();
			System.out.println("����� ��������� �Է����ּ��� : (������ (1995-12-20))");
			date = scanner.nextLine();
			birthday = birthChk(name, date);
			list.add(new Member(name, tel, address, birthday));
		}
		try {
			writer = new FileWriter("D:/WebPro/source/01_Java/ch16_io/src/com/lec/quiz/Member_writer.txt");
			for (Member member : list) {
				System.out.println(member);
				writer.write(member.toString());
			}
			String msg = "\t\t\t\t .. ����" + list.size() + " �� ����";
			System.out.print(msg);
			writer.write(msg.toString());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}

	private static Date birthChk(String name, String date) { // �Ű������� ���� ��¥ ��Ʈ���� Date������ ��ȯ�ϰ�, ������ ������ �� Ȯ���� �� return.
		Date result = null; // date�� null�� �־��� ��Ȳ�� ������ return. void �Լ��� �ƴ϶�� �ݵ�� null�� �̸� �ʱ�ȭ�� �� return������.
		StringTokenizer tokenizer = new StringTokenizer(date, "-");
		if (tokenizer.countTokens() == 3) {
			int year = Integer.parseInt(tokenizer.nextToken());
			int month = Integer.parseInt(tokenizer.nextToken()) - 1;
			int day = Integer.parseInt(tokenizer.nextToken());
			result = new Date(new GregorianCalendar(year, month, day).getTimeInMillis());
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			if (sdf.format(new Date()).equals(sdf.format(result))) {
				System.out.println(name + " ��, ������ ���ϵ帳�ϴ�!");
			} else {
				System.out.println("������ ������ �ƴϽó׿�.");
			} 
		}
		return result;
	}
}
