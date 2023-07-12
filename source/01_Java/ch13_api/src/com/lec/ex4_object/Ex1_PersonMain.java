package com.lec.ex4_object;

import com.lec.quiz1.Sawon;

public class Ex1_PersonMain {
	public static void main(String[] args) {
		Person p1 = new Person(9812121012012L); // Long형 숫자이므로 숫자 뒤에 L을 붙여줘야함. (숫자는 디폴트가 int이기 때문)
		Person p2 = new Person(9812121012012L);
		Person p3 = null;
		Sawon s = new Sawon("1", "박", "COM");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println("p1 == p2는? " + (p1==p2));
		System.out.println("p1과 p2가 같냐 : " + p1.equals(p2)); // String의 경우는 equals를 하면 true가 나오는데,
															// Person 객체도 역시 equals를 하면 true가 나오도록 하고 싶음.
		System.out.println("p1과 p3이 같냐 : " + p1.equals(p3)); // p3은 null이므로 앞에 넣을 수는 없음. (객체는 앞 가능)
		System.out.println("p2와 s가 같냐 : " + p2.equals(s));
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode()); // p1과 p2의 해시코드가 다름.
	}
}
