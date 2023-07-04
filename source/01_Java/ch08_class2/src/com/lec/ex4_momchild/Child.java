package com.lec.ex4_momchild;

public class Child {
	private String name; // (null상태)
	static MomPouch momPouch; // (null상태)
	 // 우선 mompouch와 이어지는 변수만 생성해 둠.
	
	public Child (String name) { // 메인함수에 c1 = new Child("첫째") 형식으로 만들 예정.
		this.name = name; // 매개변수로 들어온 name이 이 곳에 있는 name 변수로 대입. 한편 뒷쪽에 있는 name은 변경되지 않음. 
		// main이 아닌 child 메소드에서 제작?!
		momPouch = new MomPouch(); // mompouch를 null에서 money (int) 200라는 데이터로 넣어줌.
				
	}
	public void takeMoney (int money) {
		if(momPouch.money >= money) { // 엄마가 가진 돈이 달라는 money보다 크다면
			momPouch.money -= money; 
			System.out.println(name + "가 " + money + " 원 가져가서 엄마 지갑에 " + momPouch.money + "원 남았음.");
			
		} else {
			System.out.println(name + "가 돈 못 받음. 현재 엄마 지갑에" + momPouch.money + "원 있음.");
		}
		
		
	}
	
}
