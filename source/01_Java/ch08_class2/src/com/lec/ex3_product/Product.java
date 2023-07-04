package com.lec.ex3_product;
// 모든 상품마다 시리얼 넘버 데이터가 다르게 만들고 싶은 경우.
// 메인 메소드에서 Product p = new Product(1); ... 여기에 count를 넣는다거나 이런식으로 숫자 넣으면 되지않음?
// 알아서 객체 몇번 만들었는지 저장해주는게 있으면..
public class Product {
	private int serialNo;
	public static int count = 100; // static이 들어간 count 함수.. Product라는 메소드와 별개로 count (100) 라는 매개변수가 따로 메모리에 잡힘.
								// 이 객체는 모든 영역이 공유하게 됨.
	
	public Product() {
		serialNo = ++count; // 객체를 만들 때마다 유일한 값을 넣어야 하는 경우 static을 사용함.
		// ++count로 해야 101이 되었을때 시리얼넘버도 101이 됨.
	}
	
	
	public static void staticMethod() {
		//일반 메소드의 경우 객체를 만들어야 메모리에 등재되지만,
		// 스태틱 메소드인 경우는 그냥 메모리에 등재가 가능함.
		System.out.println("static 메소드");
	}
	
	
	public void infoPrint() {
		System.out.println("시리얼 넘버는 :" + serialNo + "\t 공유변수 count : " + count);
	}

	//getter, setter serialNo 설정. count의 경우는 static이므로 getset을 이용하지 않아도 사용가능.
	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
	
	
}
