package com.lec.ex4_object;

import java.util.Random;

public class Ex3_CardMain2 {
	public static void main(String[] args) {
		Card[] cards = { new Card("��", 3), new Card("��", 3), new Card("��", 4), new Card("��", 4), new Card("��", 5),
				new Card("��", 5), new Card("��", 6), new Card("��", 6), new Card("��", 7), new Card("��", 5) };

		// ��ǻ�Ͱ� ���� ī��� �迭 ���� ī�带 ��, ��ġ�ϴ� ī�尡 ������ ���(�ش� ī�� ���), ��ġ�ϴ� ī�� ������ ���� ��µ�.
		Random random = new Random();
		String[] kinds = { "��", "��", "��", "��" }; // ��ǻ�Ϳ��� �� 4�� �� �ϳ��� ������� ��.
		int idx = random.nextInt(4); // 0~3������ ���� ������ ����. �ش� �迭�� idx�� �����ϰ� ����.
		int idx2 = (random.nextInt(13) + 1);
		Card randomCard = new Card(kinds[idx], idx2); // kinds �迭�� idx�� ���������ϰ� ����.
		System.out.println("��ǻ�Ͱ� ���� ���� ī��� ?" + randomCard);
		int i;
		for (i = 0; i < cards.length; i++) {
			if (randomCard.equals(cards[i])) {
				System.out.println((i+1) + "��° ī��� ��ġ�մϴ�!" + cards[i]);
				break;
			} // if
		} // for
		if (i == cards.length) {
			System.out.println("�迭�� ���� ī�带 �����߽��ϴ�.");
		}

	}
}
