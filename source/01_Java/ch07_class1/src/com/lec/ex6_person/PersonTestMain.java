package com.lec.ex6_person;

public class PersonTestMain {
	public static void main(String[] args) {
		int i = 10;
		int[] arr = { 10, 20, 30, }; // �̰�ó�� �迭�� �����ϴ� �����?
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30; // �� �迭�� �濡 ���� �������ִ� ���.
		PersonInfo p1 = new PersonInfo("ȫ�浿", 20, 'm');
		// +PersonInfo[] person = {new PersonInfo("ȫ���", 22, 'f'), p1, new
		// PersonInfo("�ű浿", 33, 'm')}; //
		// ����ó�� �迭 �������ε� ���� �� ����. arr ={10,20,30} ����

		//db�� �迭ȭ�Ͽ� ����¹��.
		PersonInfo[] person = new PersonInfo[3]; //���̰� �� 3�� db�� �������.
		person[0] = new PersonInfo("ȫ���", 22, 'f'); // person�� ù��° �濡 data�� �־���.
		person[1] = p1; // ȫ�浿,20,m�� ����Ű�� �Ͱ� ������ �ּ�
		person[2] = new PersonInfo("�ű浿", 33, 'm');

		// ���� for�� �̿��Ͽ� �� ����� ��� ����ϴ� ���. (�Ϲ�for��)
		for (int idx = 0; idx < person.length; idx++) {

			System.out.println(person[idx].infoPrint()); // �׳� person[idx] ����ϸ� �ش� �ּҰ��� ����. infoprint�� ������� ������ ����ؾ���.
			System.out.println("------------");
			// Ȥ�� person[idx].print();
		}
		for (PersonInfo p : person) {
			p.print();
			System.out.println(p.infoPrint()); //Ȥ�� p.infoPrint(); �������� ����ص� ��.
			System.out.println("------------");
		}
		
	}

}
