package com.lec.ex4;

import com.lec.ex4_human.*; // 모든 클래스를 import 하겠다는 의미로. 원래는 Woman, Man 다 한줄씩 넣어야..
import com.lec.ex4_human.kid.Kid;

public class HumanTestMain {
	public static void main(String[] args) {
	   Woman woman1 = new Woman();
	   Woman woman2 = new Woman();
	   
	   System.out.println("woman1과 woman2가 같은지 여부 : " + (woman1 == woman2));
	   System.out.println("woman1과 woman2가 같은지 여부 : "+ woman1.equals(woman2));  // 기초 데이터가 아닌 객체 타입이므로 단순히 == 으로는 비교할 수 없음.
	   											// 따라서 woman.equals(대상) 로 정확히 비교하는 것이 좋음. 
	   	Man man = new Man();
	   	Kid kid = new Kid("홍아가"); // 약간만 다르면 또 다른 패키지로 취급함. (human.* 이라 해서 human.kid 패키지가 포함되는 것이 아님)
	   	Kid kid2 = new Kid(); // 기본 생성자가 없는 상태이므로 이런 상태에서 개체를 만들 수가 없음.
	   	
	   	Man kim = new Man("홍길동", 21, 178, 60); // 마지막은 double로 자동생성했으므로 59.0으로 변경됨.
	   	Man sin = new Man("신길동");
	   	Man kim2 = kim;
	   	System.out.println("kim과 kim2가 같은지 여부 : " + kim2.equals(kim)); // 같은 주소이므로 true가 됨.
	   	sin.setHeight(177);
	   	sin.setWeight(61);
	   	System.out.println("kim의 BMI 지수 :" + kim.calculateBMI());
	   	
}
}
