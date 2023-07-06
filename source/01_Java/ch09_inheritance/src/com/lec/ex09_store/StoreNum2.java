package com.lec.ex09_store;
// 대학가 매장 2호점, 부대찌개 8천원, 비빔밥 8천원, 공기밥 무료
public class StoreNum2 extends HeadQuarterStore {
	public StoreNum2(String storename) {
		super(storename);
		// 
	}
	@Override
	public void bude() {
	System.out.println("부대찌개 8천원");
	}
	
	@Override
	public void bibim() {
	System.out.println("비빔밥 8천원");
	}
	
	@Override
	public void gonggi() {
	System.out.println("공기밥 무료");
	}
	
}
