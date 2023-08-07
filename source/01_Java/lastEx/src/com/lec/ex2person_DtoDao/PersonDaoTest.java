package com.lec.ex2person_DtoDao;

import java.util.ArrayList;

// dao���� �� �۵��ϴ��� test
public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance(); // new�� �Ұ��̹Ƿ�, new�� ���� getinstance�� �����´�.
		// persondao�� �޼ҵ带 �ҷ��� �� �ֵ��� getinstance�� ��ü�� �����ϰ�, ��ü.�޼ҵ� �������� ����� �ҷ���.
		System.out.println("������� : " + dao.jnameList());
		System.out.println("1����� insert test");
		PersonDto dto = new PersonDto("ȫ�浿", "���׸�", 80, 79, 90);
		int result = dao.insertPerson(dto); // ����� insert�ƴ����� Ȯ��.
		// System.out.println(result == PersonDao.SUCCESS? "����":"����");

		System.out.println("2�����. ������ ���");
		ArrayList<PersonDto> dtos = dao.selectJname("���"); // persondto Ÿ������ �ϴ� arraylist ����. select jname�� ���� ������ ��ȯ�ϰ�
															// �Ű������� ����.
		if (dtos.isEmpty()) { // ���� dtos �迭�� ���� ���ٸ�
			System.out.println("��쿡 �ش��ϴ� �����Ͱ� �����ϴ�.");
		} else {
			for (PersonDto personDto : dtos) { // Arraylist�� Ÿ���� ���� �ݺ���.
				System.out.println(personDto);
			}
			System.out.println("��" + dtos.size() + "��");
		}
		System.out.println("2�����. ���׸����");
		dtos = dao.selectJname("���׸�");
		if (dtos.size() == 0) {
			System.out.println("���׸��� �����ϴ�");
		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx)); // �� foreach�� ����. �ش� �迭 ���̸�ŭ 1��/ 2�� / �������� ���
			}
		}

		System.out.println("3�����. ��ü����׽�Ʈ");
		dtos = dao.selectAll();
		if (dtos.isEmpty()) {
			System.out.println("�ش� �����Ͱ� �����ϴ�.");

		} else {
			for (int idx = 0; idx < dtos.size(); idx++) {
				System.out.println(dtos.get(idx)); // �迭 ��ü�� �״�� ����Ҷ��� Ȯ��for��. �� �ٸ��� ���� �߰ų� 4���� �����̶�簡 �ϰ�ʹٸ�
				if (idx % 3 == 2) {
					System.out.println("----------------------------------------------------------------------------");
					// 3�ٸ��� ��������ϵ��� ����
				}
			}
			System.out.println("��" + dtos.size() + "��");
		}
	}
}
