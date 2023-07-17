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
			lottoArr[idx] = random.nextInt(45) + 1; // 1���� 46 ������ ���� 1�� �߻���Ŵ x6

		}
		System.out.println(Arrays.toString(lottoArr));
		TreeSet<Integer> lotto = new TreeSet<Integer>(); // while���� ������, �ζ� ���ڸ� 6�� �̱� ���� hashset.size()= 6�� �Ǿ����.
		int cnt = 0; // Ƚ���� ���� ���ؼ�
		while (lotto.size() < 6) {
			cnt++;
			lotto.add(random.nextInt(45) + 1);
		} // �� �� ����ƴ����� ������, ���̰� 6�� �� ������ Ȯ���� �ݺ���.
		System.out.println(cnt + "�� ���� �ζ� ��ȣ : " + lotto); // treeset�� ����ϸ� ������ ����
	}
}
