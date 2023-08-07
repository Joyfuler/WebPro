package com.lec.ex2person_DtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		Scanner scanner = new Scanner(System.in);
		String fn; // �����Է¹�ȣ
		ArrayList<String> jobs = dao.jnameList(); // ��������Ʈ ����ϴ� PersonDaoŬ����Ÿ���� �迭
		
		do {
			System.out.print("1:�Է�, 2:���������, 3:��ü���, ��Ÿ�Է�:����");
			fn = scanner.next();
			
			switch (fn) {
			case "1": // ����ڷκ��� �̸�,������,��,��,�� �Է¹޾� insertPersonȣ��
				System.out.println("�Է��� �̸���?");
				String pname = scanner.next();
				System.out.println("�Է��� �����̸���? : (" + jobs + ")");
				String jname = scanner.next();
				System.out.println("�Է��� �������?");
				int kor = scanner.nextInt();
				System.out.println("�Է��� �������?");
				int eng = scanner.nextInt();
				System.out.println("�Է��� ���м�����?");
				int mat = scanner.nextInt();								
			dao.insertPerson(new PersonDto(pname,jname,kor,eng,mat)); // insertperson �� �� �� Ÿ������! new PersonDto				
			break;			
			case "2": System.out.println("2�� ���");
				System.out.println("����� ���ϴ� ������ �Է��ϼ���. : (" + jobs + ")");
				jname = scanner.next();
				ArrayList<PersonDto> dtos = dao.selectJname(jname); // �ش� �����̸� ��������� ����ϴ� sql �޼ҵ�. ����� arraylist
				if (dtos.isEmpty()) {
					System.out.println(jname +" ������ ���� ����� �����ϴ�.");
				} else {
					for (PersonDto dto : dtos) {
						System.out.println(dto);						
					}				
				}
			break;						
			case "3":
			dtos = dao.selectAll();
			if (dtos.isEmpty()) {
				System.out.println("����� �����Ͱ� �����ϴ�.");
			} else {
				for (int idx = 0; idx<dtos.size(); idx++) {
					System.out.println(dtos.get(idx)); // arraylist�迭�̹Ƿ� [idx]�� �ƴ�, get(idx)�� ����Ͽ� �����.					
				}
				System.out.println("��" + dtos.size() + "��");
			}
			break;
			}			
		} while(fn.equals("1")||fn.equals("2")||fn.equals("3")); // 1,2,3�̸� �ݺ�, �ٸ�Ű�� ����
		System.out.println("BYE");
			
		
	}
}
