package com.lec.ex3_set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex03_lotto {
	public static void main(String[] args) {
		Random random = new Random();
		int[] lottoArr = new int[6];
		for (int idx = 0; idx < lottoArr.length; idx++) {
			lottoArr[idx] = random.nextInt(45) + 1; // 1부터 46 사이의 값을 1개 발생시킴 x6

		}
		System.out.println(Arrays.toString(lottoArr));
		TreeSet<Integer> lotto = new TreeSet<Integer>(); // while문을 돌리고, 로또 숫자를 6개 뽑기 위해 hashset.size()= 6이 되어야함.
		int cnt = 0; // 횟수를 보기 위해서
		while (lotto.size() < 6) {
			cnt++;
			lotto.add(random.nextInt(45) + 1);
		} // 몇 번 실행됐는지는 모르지만, 길이가 6이 될 때까진 확실히 반복함.
		System.out.println(cnt + "번 뽑은 로또 번호 : " + lotto); // treeset을 사용하면 정렬이 가능
	}
}
