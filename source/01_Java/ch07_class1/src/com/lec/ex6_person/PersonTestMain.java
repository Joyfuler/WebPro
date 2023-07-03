package com.lec.ex6_person;

public class PersonTestMain {
	public static void main(String[] args) {
		int i = 10;
		int[] arr = { 10, 20, 30, }; // 이것처럼 배열로 저장하는 방법은?
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30; // 각 배열의 방에 값을 설정해주는 방법.
		PersonInfo p1 = new PersonInfo("홍길동", 20, 'm');
		// +PersonInfo[] person = {new PersonInfo("홍길순", 22, 'f'), p1, new
		// PersonInfo("신길동", 33, 'm')}; //
		// 다음처럼 배열 형식으로도 만들 수 있음. arr ={10,20,30} 형태

		//db를 배열화하여 만드는방법.
		PersonInfo[] person = new PersonInfo[3]; //길이가 총 3인 db를 만들어줌.
		person[0] = new PersonInfo("홍길순", 22, 'f'); // person의 첫번째 방에 data를 넣어줌.
		person[1] = p1; // 홍길동,20,m을 가르키는 것과 동일한 주소
		person[2] = new PersonInfo("신길동", 33, 'm');

		// 이후 for를 이용하여 각 명단을 모두 출력하는 방법. (일반for문)
		for (int idx = 0; idx < person.length; idx++) {

			System.out.println(person[idx].infoPrint()); // 그냥 person[idx] 출력하면 해당 주소값이 나옴. infoprint로 결과값을 리턴해 출력해야함.
			System.out.println("------------");
			// 혹은 person[idx].print();
		}
		for (PersonInfo p : person) {
			p.print();
			System.out.println(p.infoPrint()); //혹은 p.infoPrint(); 형식으로 출력해도 됨.
			System.out.println("------------");
		}
		
	}

}
