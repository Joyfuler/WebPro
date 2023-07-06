package com.lec.ex09_store;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore headQuarterStore = new HeadQuarterStore("===본사===");
		HeadQuarterStore storenum1 = new StoreNum1 ("===주택가 1호점===");
		HeadQuarterStore storenum2 = new StoreNum2("=== 대학가 2호점 ===");
		HeadQuarterStore storenum3 = new StoreNum3 ("=== 증권가 3호점 ===");
		HeadQuarterStore[] stores = {
				new HeadQuarterStore("===본사==="),
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