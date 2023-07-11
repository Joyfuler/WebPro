package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("성별을 확인할 주민번호를 입력해주세요.");
		String juminNo = scanner.next();
		String genderStr = juminNo.substring(7, 8);
			// but 주민번호 뒷자리의 string을 숫자로 변환한다면?
			int genderInt = Integer.parseInt(genderStr); // genderStr을 숫자로 변환하는 함수. integer.parseint...
			if (genderInt == 1 || genderInt == 3) {
				System.out.println("남자입니다.");
			} else if (genderInt == 2 || genderInt == 4) {
				System.out.println("여자입니다.");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

