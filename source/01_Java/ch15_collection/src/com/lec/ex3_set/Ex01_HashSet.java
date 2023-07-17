package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		/*
		 * String s0 = "str0"; String s1 = new String("str0");
		 * System.out.println(s0==s1); // ���� �ּҰ� �ٸ��Ƿ� �̷��� ���ϴ� ���� false�� ����. �׷���...
		 * System.out.println(s0.equals(s1)); // ���� ���� ���ϸ� true�� ����. ����
		 * System.out.println(s0.hashCode()); System.out.println(s1.hashCode()); // ����
		 * �ؽ��ڵ嵵 �����ϰ� ��µ�.
		 */		
		
		HashSet<String> hashset = new HashSet<String>();
		hashset.add("str0");
		hashset.add("str1"); // �ι��� �����͸� ���� ��, ù��° �����Ϳ� ���� �ٸ� ���(false)�� ��� �߰���.
		hashset.add("str2"); // ����° �����͸� ���� ��, ù��° �����Ϳ� �� �� �� �ι�° �����Ϳ� �� ��
		System.out.println(hashset); //�����Ѱ��� ������
		System.out.println(hashset.size());
		hashset.add("str2"); // �׹�° �����͸� �������� �ϴµ�, ����° �����Ϳ� ���� ���� ��� true�� ����.
								// ���� ���ٸ�, "str2".hashcode()�� "str2".hashcode() ��� ���Ͽ� true���?
		System.out.println("�ߺ� ������ add �� " + hashset); // �ش� ���� �߰����� �ʴ� ���.
		System.out.println("�ߺ� ������ add �� " + hashset.size());
		Iterator<String> iterator = hashset.iterator(); // Ű�� �����Ƿ� getkey�� �Ұ���.
		while (iterator.hasNext()) {
			System.out.println(iterator.next()); // �迭�� ���� ���� �ִµ��� ���. ��, idx�� �����Ƿ� ������ ������
		}
	}
}
