package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		int[] arr = new int[5]; // 총 5 칸짜리 int배열만듬

		String[] array = new String[3]; // String형 배열.
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		System.out.println(Arrays.toString(array)); // 배열을 바로 출력하는 방법. Arrays.tostring() 이용.. 혹은
		for (String arrs : array) {
			System.out.println(arrs); // 값만을 모두 가져옴. 배열 숫자와 함꼐 가져오려면 for문사용.
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(i + " 번 인덱스 값 : " + array[i]); // 그러나 배열의 숫자를 늘리거나 줄일 수 없다는 단점

		}

		System.out.println("---------------------------ArrayList--------------------------------");

		ArrayList<String> arrayList = new ArrayList<>(); // String형 arraylist
		arrayList.add("str0"); // 0번 인덱스에 str 넣은 것과 동일함.
		arrayList.add("str0");
		arrayList.add("str0"); // 배열 길이를 계속해서 추가가 가능.
		arrayList.add(1, "str1111"); // 1번 인덱스값을 추가할 수도 있음. 이 경우 1번 이후 인덱스에 있던 데이터는 한칸씩 내려감.
		arrayList.set(2, "str2222"); // set을 통해 인덱스를 고르고, 해당 배열의 데이터를 수정할 수도 있음.
		System.out.println("arrayList의 사이즈 : " + arrayList.size()); // 만일 arraylist의 size가 0이라면, 해당하는 db가 없다는 의미.
		arrayList.add("str4");
		System.out.println("arrayList의 사이즈 : " + arrayList.size());
		System.out.println(arrayList); // sout에 넣기만 하면, 알아서 출력이 가능함. 기존 배열의 경우는 arrays.tostring 사용필요..
		// 만일 for문을 돌린다면?
		for (String strings : arrayList) {
			System.out.print(strings + "\t");			
		}
		for (int i =0; i < arrayList.size(); i++) {
			System.out.println(i + "번째 인덱스 값 : + " + arrayList.get(i)); // 일반 배열과는 달리, get(int i) 로 입력함. 
		}
		//arrayList.remove(2);
		arrayList.remove("str2222");
		arrayList.remove(arrayList.size()-1);
		System.out.println("2 번 인덱스 값과 마지막 값 remove 후");
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(i + "번 인덱스 값 : " + arrayList.get(i));			
		}
		arrayList.clear(); // 해당 arrayList의 모든 값을 0으로 청소함. (단, arrayList는 자체는 남아있음)
		System.out.println(arrayList.size()==0? "데이터 제거 완료" : "데이터 있음");
		System.out.println(arrayList.isEmpty()? "데이터 제거 완료" : "데이터 있음");
		// isEMpty에서 비어있으면 true 리턴, 아니면 false 리턴
		// 만일 arrayList 자체를 없애고 싶다면? null을 대입
		//arrayList = null;
		//System.out.println(arrayList.size());
	}
}
