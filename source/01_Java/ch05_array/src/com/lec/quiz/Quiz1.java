package com.lec.quiz;

public class Quiz1 {
	public static void main(String[] args) {
		// 76 45 34 89 100 50 90 92
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		for (int i = 0; i < arr.length - 1; i++) { // 큰수와 자리수 자리를 바꿀때 임시변수를 넣어줌
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) { // 앞열이 뒷열보다 크면
					int temp = arr[i]; // temp 변수에 앞열수를 임시로 배치함
					arr[i] = arr[j]; // 작았던 뒷열수는 앞열로
					arr[j] = temp; // 컸던 수는 뒤로감. // 즉 작은 수부터 점점 큰수로 간다는 것.

				}

			}
			System.out.print(arr[i] + " ");
		}
		// 큰수에서 점점 작은 수가 되려면?
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) { // 앞열이 뒷열보다 작으면?
					int temp = arr[i]; // temp 변수에 앞열수를 임시로 배치함.
					arr[i] = arr[j]; // 컸던 뒷열수는 앞열로
					arr[j] = temp; // 작았던 수는 뒤로감.

				}
			}
			System.out.print(arr[i] + " "); // 큰수부터 작은수로 정렬.
		}

		// 0번째 배열 i와 1,2,3열 j를 비교한 후 1번째 배열 i와 2,3열 j를 비교..
		// i=j 식으로 변경하면 같은 수가 됨. 임시 변수를 만들어 저장해줘야..

	}
}
