package com.lec.ex09_store;
// 부대찌개 8천원, 순대국 안팔아
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String storename) {
		super(storename); // 에러날땐 오류클릭해서 생성자 있는것으로 바로 생성해주기
		
	} 
	@Override
	public void bude() {
	System.out.println("부대찌개 8천원");
	}
	
	@Override
	public void sunde() {
	System.out.println("순대국 안팔아");
	
	}
}
