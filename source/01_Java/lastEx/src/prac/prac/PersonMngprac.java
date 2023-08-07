package prac.prac;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMngprac {
	public static void main(String[] args) {
		PersonDaoprac daoprac = PersonDaoprac.getInstance();
		ArrayList<String> jobs = daoprac.jnamelist();		
		Scanner scanner = new Scanner(System.in);
		String fn = null;
		
		
		do {
			System.out.println("���ϴ� ����� �����ϼ���. 1:�Է� 2:��������� 3:��ü���");
			fn = scanner.next();
			
		switch (fn) {
		case "1":
			System.out.println("�Է��� �̸���?");
			String pname = scanner.next();
			System.out.println("�Է��� ��������? : (" + jobs + ")");
			String jname = scanner.next();
			System.out.println("�Է��� �������?");
			int kor = scanner.nextInt();
			System.out.println("�Է��� �������?");
			int eng = scanner.nextInt();
			System.out.println("�Է��� ���м�����?");
			int mat = scanner.nextInt();
			daoprac.insertPerson(new PersonDtoprac(pname,jname,kor,eng,mat));
			break;
			
		case "2": 
			System.out.println("����� ���ϴ� ������ �Է��ϼ���. (" + jobs + ")");
			jname = scanner.next();
			ArrayList<PersonDtoprac> dtos = daoprac.selectJname(jname);
			if (dtos.isEmpty()) {
				System.out.println("�ش� ������ ���� ����� �����ϴ�.");				
			} else {
				for (PersonDtoprac personDtoprac : dtos) {
					System.out.println(personDtoprac);
				}
				System.out.println("�� " + dtos.size() + "��");
			}
			break;
			
		case "3":
			dtos = daoprac.selectAll();
			if (dtos.isEmpty()) {
				System.out.println("�����Ͱ� ��µ��� �ʾҽ��ϴ�.");
			} else {
				for (PersonDtoprac personDtoprac : dtos) {
					System.out.println(personDtoprac);
				}
				System.out.println("�� " + dtos.size() + "��");
			}
			
			break;
		}
		
		
		} while (fn.equals ("1") || fn.equals ("2") || fn.equals("3"));
		System.out.println("BYE");
	}
}
