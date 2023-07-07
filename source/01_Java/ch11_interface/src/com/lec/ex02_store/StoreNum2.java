package com.lec.ex02_store;
// 대학가 매장 2호점, 부대찌개 8천원, 비빔밥 8천원, 공기밥 무료
public class StoreNum2 implements HeadQuarterStore {
	
	public String storeName;
	public StoreNum2(String storename) {
		this.storeName = storename;
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
	@Override
	public void kimchi() {
	System.out.println("김치찌개 8,000원");
		
	}
	@Override
	public void sunde() {
	System.out.println("순대국 8,000원");
		
	}
	@Override
	public String getStorename() {
		// TODO Auto-generated method stub
		return storeName;
	}
	
}
