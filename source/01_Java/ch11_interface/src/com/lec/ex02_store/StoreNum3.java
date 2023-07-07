package com.lec.ex02_store;
// 증권가 매장 3호점 김치찌개 9천원, 부대찌개 만원, 비빔밥 만원, 얼큰순대국 9천원
public class StoreNum3 implements HeadQuarterStore {

	public String storeName;
	public StoreNum3(String storename) {
		this.storeName = storename;	
	}
	@Override
	public void kimchi() {
	System.out.println("김치찌개 9천원");
	}
	@Override
	public void bude() {
	System.out.println("부대찌개 만원");
	}
	@Override
	public void bibim() {
	System.out.println("비빔밥 만원");
	}
	@Override
	public void sunde() {
	System.out.println("얼큰순대국 9천원");
	}
	public void ulkeun() {
		System.out.println("얼큰순대국 9천원");
	}
	@Override
	public void gonggi() {
		System.out.println("공기밥 1,000원");
		
	}
	@Override
	public String getStorename() {
		// TODO Auto-generated method stub
		return storeName;
	}
}
