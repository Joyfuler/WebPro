package com.lec.ex09_store;

//본사 지침 : 김치찌개 8천원, 부대찌개 9천원, 비빔밥 9천원, 순대국 8천원, 공기밥 1000원
// HeadQuarterStore hs = new HeadQuarterStore("==본사==")

public class HeadQuarterStore {
	private String storename;

		

	public HeadQuarterStore(String storename) {
		this.storename = storename;
	}
	public void kimchi() {
		System.out.println("김치찌개 8,000원");
	}
	
	public void bude () {
		System.out.println("부대찌개 9,000원");		
	}
	public void bibim () {
		System.out.println("비빔밥 9,000원");
	}
	public void sunde () {
		System.out.println("순대국 8,000원");
	}
	public void gonggi() {
		System.out.println("공기밥 1,000원");
	}
	public String getStorename() {
		return storename;
	}
}
