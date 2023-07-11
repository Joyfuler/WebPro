package com.lec.ex1_string;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String tellNo;
		while (true){ // true값이니 당연히 무한반복.
			System.out.println("전화번호를 입력해주세요. 나가려면 X를 눌러주세요.");

			tellNo = scanner.next();
		    if(tellNo.equalsIgnoreCase("x")) { // if문을 데이터 입력 직후에 적용받도록. 그렇지 않으면 아래를 쭉 진행함..
		    	break; // x를 누를 시 break가 걸리며 괄호 밖으로 바로 넘어가게 됨.
		    }
			System.out.println("입력한 전화번호: " + tellNo);
			System.out.print("짝수번째 문자열: ");
			for (int i = 0; i < tellNo.length(); i++) {
				if (i % 2 == 0) {
					System.out.print(tellNo.charAt(i) + " ");
				}
			}
			System.out.print("\n문자를 거꾸로 : ");
			for (int idx = tellNo.length()-1; idx >= 0; idx--) { // 맨 뒷글자 번호부터 반복으로 출력. length() -1에 주의!
				System.out.print(tellNo.charAt(idx));
			}
			int preIdx = tellNo.indexOf("-");
			System.out.print("\n전화번호 맨 앞자리는: ");
			System.out.println(tellNo.substring(0, preIdx));
			System.out.print("전화번호 뒷자리는: ");
			System.out.println(tellNo.substring(tellNo.lastIndexOf("-") + 1, tellNo.length()));
		} 
		System.out.println("입력을 종료합니다.");
		scanner.close();
	}
}
