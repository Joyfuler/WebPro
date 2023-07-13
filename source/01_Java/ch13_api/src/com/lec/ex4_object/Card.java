package com.lec.ex4_object;

// ���� - ������, ������, �޼ҵ�(�Ϲ�, getset,�������̵�)
// new Card("��",3) ������� ������ ����.
public class Card {

	private String kind;
	private int num;

	public Card(String kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "[ī���] : " + kind + "-" + num;
	}

	public boolean equals(Object obj) {
		// c1.equals(c2)�� �����, c1�� (this(kind)�� �ǰ�, c2�� obj�� ���Ե�.
		// this.kind�� obj.kind�� �������� check. // ���� �������?
		// (this.num)�� obj.num�� �������� üũ. // ���� ��������??
		// �Ѵ� ���� ��, return kindChk && numChk

		if (obj != null && obj instanceof Card) {
			Card other = (Card) obj; // ����ȯ.
			boolean kindChk = (kind.equals(((Card) obj).kind));
			boolean numChk = (num == (other.num));
			return (kindChk && numChk);
		}
		return false;

	}

}
