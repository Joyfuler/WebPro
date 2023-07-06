package com.lec.ex01_store;
// 추상 클래스: 추상 메소드(선언만 한 메소드)가 1개 이상 있는 경우 class 앞에 abstract를 붙여 만든 클래스.
// 상속받은 클래스에 오버라이드를 강요.
// 각 음식메뉴를 빼먹지 않도록...

public abstract class HeadQuarterStore { // 추상클래스가 있는 경우는 class 앞에도 abstract를 붙일것
	private String storename;

		

	public HeadQuarterStore(String storename) {
		this.storename = storename;
	}
	public abstract void kimchi(); 
	// 모든 메뉴를 따로 오버라이드 해야한다면?
	// 반드시 오버라이드 하도록 할 수 있음. --> kimchi라는 메소드를 선언만 한 것 (); 로 마무리... 
	
	public abstract void bude();
	public abstract void bibim ();
	public abstract void sunde();
	public abstract void gonggi();
	public String getStorename() {
		return storename;
	}
}
