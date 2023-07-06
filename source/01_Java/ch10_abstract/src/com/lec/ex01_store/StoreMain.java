package com.lec.ex01_store;

public class StoreMain {
	public static void main(String[] args) {
		//abstract인 경우 비어있는 메소드가 있으므로 호출하지 못하도록 에러가 발생함.
		// 따라서 추상클래스는 객체를 생성할 수 없음. 단, 변수선언은 가능. 아무튼 생성안됨
		// HeadQuarterStore headQuarterStore = new HeadQuarterStore("===본사===");
		HeadQuarterStore storenum1 = new StoreNum1 ("===주택가 1호점===");
		HeadQuarterStore storenum2 = new StoreNum2("=== 대학가 2호점 ===");
		HeadQuarterStore storenum3 = new StoreNum3 ("=== 증권가 3호점 ===");
		HeadQuarterStore[] stores = {
			//	new HeadQuarterStore("===본사==="),
				new StoreNum1 ("===주택가 1호점==="),
				new StoreNum2("=== 대학가 2호점 ==="),
				new StoreNum3("=== 증권가 3호점 ===")};
				
		for (HeadQuarterStore st : stores) {
			System.out.println(st.getStorename());
			st.kimchi();
			st.bude();
			st.bibim();
			st.sunde();
			st.gonggi();
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
		}
		
		for (int idx = 0; idx < stores.length; idx++) {
			System.out.println(stores[idx].getStorename());
			stores[idx].kimchi();
			stores[idx].bude();
			stores[idx].sunde();
			stores[idx].gonggi();
		
		}	
}
}