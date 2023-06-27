package com.lec.ex;

import javax.swing.text.GapContent;

public class VarEx04 {
	public static void main(String[] args) {
		int i = 40; // 4바이트
		long l = 2200000000L; // 수는 기본적으로 int이므로 long을 대입해도 들어가지 않음. 뒤에 L을 붙여줘야..
		System.out.println("l = " + l);
		boolean b = true; // 1바이트
		System.out.println("b = " + b); // true 혹은 false로
		
		// 실수는 double이 기본. float는...? 
		float f = 3.1415926539F; // float는 4바이트이므로 들어가지 않음. 
		System.out.println("f = " + f);
		double d = 3.1415926539; // 8바이트
		System.out.println("d = " + d);
		
		if (f == d) { // if else 구문. if (a) { } else { }
		System.out.println("f와 d가 같다");
		}	else {
			System.out.println("f와 d가 다르다");
						
		}
		 f = 10.1f;
		 d = 10.1;
		 
		 System.out.println("f = " + f);
		 System.out.println("d = " + d);
		 if (f == d) {
			 System.out.println("f와 d가 같다");
		 } else {
			System.out.println("f와 d가 다르다"); // 같은 수지만 다른 것으로 판단됨.
		}
		 double result = d + 1; // 8byte + 4byte
		 System.out.println("d+1 = " + result);
		 i = 3;
		 // i 는 3일 때, 3을 2로 나누면? // 4바이트와 4바이트를 계산했기에 결과도 4바이트. 따라서 소숫점이 나오지 않음(몫만 나옴)
		 System.out.println("i/2 =" + i/2); // 결과는 1.5가 아닌 1
		 System.out.println("(double)i/2 =" + ((double)i/2)); // i를 double로 변경하니 결과가 1.5로 바뀜.
		 System.out.println("i/2.0 =" + i/2.0); // 나누는 수를 2에서 2.0으로 변경하면 결과가 1.5로 바뀜.
		 }
	}


