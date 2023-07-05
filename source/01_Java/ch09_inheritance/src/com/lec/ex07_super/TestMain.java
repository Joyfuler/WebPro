package com.lec.ex07_super;

public class TestMain {
	public static void main(String[] args) {
		Person papa = new Person("아빠곰", "뚱뚱해"); // 아빠곰, 뚱뚱해 매개변수가 들어가는 papa 객체 생성
		papa.setName("아빠곰"); papa.setCharacter("뚱뚱해");
		papa.intro(); // person의 intro 실행
		Person mom = new Person("엄마곰", "날씬해");
		mom.intro();
		Person child1 = new Baby(); // 매개변수가 없는 케이스에는 setname, setcharacter사용
		child1.setName(" 아기곰1"); child1.setCharacter("귀여워");
		child1.intro();
		Person child2 = new Baby("아기곰2", "너무귀여워"); // 매개변수 2개를 넣은 child2
		child2.intro(); // 이미 매개변수 2개가 있으므로 매개변수 있는 person생성자쪽을 바로 호출하게됨.
		
	}
	
	
	

}
