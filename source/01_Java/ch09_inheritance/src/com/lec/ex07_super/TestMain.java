package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("�ƺ���", "�׶���"); // �ƺ���, �׶��� �Ű������� ���� papa ��ü ����
		papa.setName("�ƺ���"); papa.setCharacter("�׶���");
		papa.intro(); // person�� intro ����
		Person mom = new Person("������", "������");
		mom.intro();
		Person child1 = new Baby(); // �Ű������� ���� ���̽����� setname, setcharacter���
		child1.setName(" �Ʊ��1"); child1.setCharacter("�Ϳ���");
		child1.intro();
		Person child2 = new Baby("�Ʊ��2", "�ʹ��Ϳ���"); // �Ű����� 2���� ���� child2
		child2.intro(); // �̹� �Ű����� 2���� �����Ƿ� �Ű����� �ִ� person���������� �ٷ� ȣ���ϰԵ�.
		
	}
	
	
	

}
