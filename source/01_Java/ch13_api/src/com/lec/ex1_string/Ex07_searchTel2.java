package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 뒷자리가 중복된다면?
public class Ex07_searchTel2 {
	public static void main(String[] args) {
		String[] tels = { "010-9999-9999", "010-8888-7777", "010-7777-7777" }; // 7777 이 중복되는 전화번호 2개
		Scanner scanner = new Scanner(System.in);
		while (true) { System.out.println("검색할 사람의 전화번호 뒷자리를 입력해주세요. 그만 하시려면 X를 입력해주세요.");
		// while (true) 잊지말것!
		boolean searchOk = false; // 중복된 전화번호가 있는 경우 - boolean을 false로 설정한 후 찾으면 true로 변경
		String searchTel = scanner.next(); // "7777"?
		if (searchTel.equalsIgnoreCase("x")){
			break;
		}
		
		for (int i = 0; i < tels.length; i++) { // 배열의 총 갯수 순회
			int postIdx = tels[i].lastIndexOf("-"); // postIdx를 생성, 각 배열의 마지막 -이 있는 배열을 가져옴.
			String postTel = tels[i].substring(postIdx + 1); // 전화번호 뒷자리를 끝까지 출력하려면 배열의 +1을 해야..
			if (postTel.equals(searchTel)) {
				System.out.println("검색하신 전화번호는" + tels[i] + "입니다. ");
				searchOk = true; // 찾았을 경우, seachOk를 true로 만들어 줌.
			}
		}
		if (!searchOk) { // 핸드폰 번호를 찾지 못한경우. !searchOk = ( seachOk == false)
			System.out.println("입력하신 전화번호 뒷자리를 찾을 수 없습니다. 회원가입 시 ...");
		}
		}
		scanner.close();

	}
}
