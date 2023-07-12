package com.lec.ex4_object;

// Ŭ�������� ������(private), ������, �Ϲݱ��, �޼ҵ�(setter&getter), tostring(), �������̵��� �޼ҵ�
// Person p1 = new Person(); // ��ü����. �ƹ��͵� ���� --> null�� ����
// Person p2 = new Person(9812121012012L); // �ֹι�ȣ�� �� ��ü������. long juminNo�� ���� �ּ�
public class Person {
	private long juminNo; // �ֹι�ȣ�� �� 13�ڸ�. ���ڷ� �Է��Ѵٸ� long�ʿ�

	public Person() {
	} // ����Ʈ�������Լ�..

	public Person(long juminNo) { // Personmain���� ������� ��ü�� �� ������ ��ħ.
		super();
		this.juminNo = juminNo;
	}

	@Override
	public String toString() { // sout�Ҷ� �� ������ �������� Ȯ���ϱ� ���ؼ��� tostring�� �������̵带 ������.
		return "�ֹι�ȣ�� [" + juminNo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2) : (p1-this, p2-obj).. this.juminNo�� obj.juminNo�� ������ true, Ʋ����
		// false ����
		if (obj != null && obj instanceof Person) { // null�� �ƴϰ�, obj�� PersonŸ���� ��쿡��. instanceof�� �ش� Ÿ���̶�� �ǹ�..
			Person other = (Person) obj; // ����ȯ�� other�� ����. �ؿ��ٰ� (Person)obj).juminNo�� �� �Ͱ� ������.
			boolean juminNoChk = (juminNo == other.juminNo); // �� juminNo�� �� obj.juminNo (��ü�� juminNo)
			return juminNoChk; // ���� if�� ���� ���� juminNoChk�� return�ϰ�,
		}
		return false; // if�� �����̶�� false�� return��.
	}

}
