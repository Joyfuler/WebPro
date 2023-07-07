package com.lec.ex02_store;
// 부대찌개 8천원, 순대국 안팔아
public class StoreNum1 implements HeadQuarterStore {

	public String storeName;
	public StoreNum1(String storename) {
		this.storeName = storename; // 에러날땐 오류클릭해서 생성자 있는것으로 바로 생성해주기
		
	} 
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 8,000원");
	}
	
	@Override
	public void bude() {
	System.out.println("부대찌개 8천원");
	}
	
	@Override
	public void sunde() {
	System.out.println("순대국 안팔아");
	
	}

	@Override
	public void bibim() {
	System.out.println("비빔밥 9,000원");
		
	}

	@Override
	public void gonggi() {
	System.out.println("공기밥 1,000원");
		
	}

	@Override
	public String getStorename() {
		return storeName;
	}
}
