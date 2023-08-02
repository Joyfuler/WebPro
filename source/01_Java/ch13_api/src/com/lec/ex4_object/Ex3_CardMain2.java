package com.lec.ex4_object;

import java.util.Random;

public class Ex3_CardMain2 {
	public static void main(String[] args) {
		Card[] cards = { new Card("♥", 3), new Card("◆", 3), new Card("♥", 4), new Card("◆", 4), new Card("◆", 5),
				new Card("♠", 5), new Card("♣", 6), new Card("♣", 6), new Card("♠", 7), new Card("♥", 5) };

		// 컴퓨터가 뽑은 카드와 배열 안의 카드를 비교, 일치하는 카드가 나오면 출력(해당 카드 출력), 일치하는 카드 없으면 땡이 출력됨.
		Random random = new Random();
		String[] kinds = { "♥", "♣", "◆", "♠" }; // 컴퓨터에게 이 4개 중 하나를 뽑으라고 함.
		int idx = random.nextInt(4); // 0~3사이의 정수 난수를 선택. 해당 배열의 idx를 선택하게 만듬.
		int idx2 = (random.nextInt(13) + 1);
		Card randomCard = new Card(kinds[idx], idx2); // kinds 배열의 idx를 랜덤선택하게 만듬.
		System.out.println("컴퓨터가 뽑은 랜덤 카드는 ?" + randomCard);
		int i;
		for (i = 0; i < cards.length; i++) {
			if (randomCard.equals(cards[i])) {
				System.out.println((i+1) + "번째 카드와 일치합니다!" + cards[i]);
				break;
			} // if
		} // for
		if (i == cards.length) {
			System.out.println("배열에 없는 카드를 선택했습니다.");
		}

	}
}
