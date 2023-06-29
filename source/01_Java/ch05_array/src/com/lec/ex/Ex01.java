package com.lec.ex;

public class Ex01 {
	public static void main(String[] args) {
		int i = 20; //지금까지 만들었던 변수 수타일
		// i = 30; // i가 30으로 바뀜, 기존 20은 날아감.
		
		// 1. 배열 변수의 선언과 초기화
		int[] iArr = {10, 20, 30, 40, 50}; // 구분[] 이름 = {목록}... 배열로 초기화한것. 
		// String과 마찬가지로 다른 곳에 있는 데이터의 번지수를 대신 적으므로 객체 변수가 됨 
		// 10은 0번째, 총 4번째까지 데이터 존재. 
		iArr[2] = 300; // 여기서 괄호 안 1은 index (순서).. 세번째에 300을 대입함.
		
		for (int j=0; j< iArr.length; j++) { // iArr.length : iArr 배열 방의 갯수를 뜻함.
		System.out.println(iArr[j] + ""); //만일 배열 범위 벗어나는경우  ArrayIndexOutOfBoundsException 오류발생
		System.out.println(j + "번째 방의 값은" + iArr[j]);
		}
		
		// 2. 배열 변수 선언과 배열 메모리 확보
		// 배열 역시 int i; 와 마찬가지로 선언만 하고 나중에 값을 넣을 수 있음.
		int [] iArr2 = new int[5]; // iArr2의 방 수만 확보한 후 0으로 초기화한 상태. 즉 {0,0,0,0,0}, new는 공간을 확보한다는 의미. 오른쪽것의 주소를 가져온다는 것. 
		iArr2[2] = 99; // {0,0,99,0,0}
		for (int idx =0 ; idx < iArr2.length; idx++) {
			System.out.println(iArr2[idx]);
			System.out.printf("iArr2[%d] = %d \n", idx, iArr2[idx]);
				
		
		}
		
		// 3. 배열 변수 선언
		int[] iArr3; // 배열로 된 변수 iArr3이 만들어짐. 그러나 배열이 몇 칸인지 등 방 생성은 x 
		// iArr3[0] = 99; --> 배열이 초기화되지 않았으므로 0번째 방의 값이 정의되거나 값을 바꿀 수 없음.
		iArr3 = new int[3]; // {0,0,0} 으로 배열을 초기화해주었음.
		iArr3[0] = 99; // {99,0,0}
		for (int idx2=0 ; idx2 < iArr3.length; idx2++) {
			System.out.println(idx2 + "번 째 :" + iArr3[idx2]);
		}
		
	} // main
} // class
