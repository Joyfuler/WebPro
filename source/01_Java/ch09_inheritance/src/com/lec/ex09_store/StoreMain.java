package com.lec.ex09_store;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore headQuarterStore = new HeadQuarterStore("===����===");
		HeadQuarterStore storenum1 = new StoreNum1 ("===���ð� 1ȣ��===");
		HeadQuarterStore storenum2 = new StoreNum2("=== ���а� 2ȣ�� ===");
		HeadQuarterStore storenum3 = new StoreNum3 ("=== ���ǰ� 3ȣ�� ===");
		HeadQuarterStore[] stores = {
				new HeadQuarterStore("===����==="),
				new StoreNum1 ("===���ð� 1ȣ��==="),
				new StoreNum2("=== ���а� 2ȣ�� ==="),
				new StoreNum3("=== ���ǰ� 3ȣ�� ===")};
				
		for (HeadQuarterStore st : stores) {
			System.out.println(st.getStorename());
			st.kimchi();
			st.bude();
			st.bibim();
			st.sunde();
			st.gonggi();
			System.out.println("�������������������������������");
			
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