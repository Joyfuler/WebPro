package com.lec.condition;

// if vs. switch
public class Ex03_switch {
	public static void main(String[] args) {
		int num = 3
				;
//		if (num == 1) {
//			System.out.println("주사위 1");
//		} else if (num == 2) {
//			System.out.println("주사위 2");
//		} else if (num == 3) {
//			System.out.println("주사위 3");
//		} else if (num == 4) {
//			System.out.println("주사위 4");
//		} else if (num == 5) {
//			System.out.println("주사위 5");
//		} else {
//			System.out.println("주사위 6");
		// switch(정수형, 문자형, 문자열만 가능. )
		switch (num) {
		case 1 : 
			System.out.println("주사위 1");	break;
		case 2 : 
			System.out.println("주사위 2");	break;
		case 3 : 
			System.out.println("주사위 3");   break; // 입력하지 않을 시 아래 case에 모두 입력됨
		case 4 : 
			System.out.println("주사위 4");	break;
		case 5 : 
			System.out.println("주사위 5");	break;
		default : 
			System.out.println("주사위 6");   break;
		} // else
	} // main
} // class

