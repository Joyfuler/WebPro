package com.lec.ex3_math;

import java.util.Random;

// 난수발생 기존 --> Math.random() 사용. 0에서 1사이의 랜덤실수발생.
// ex가위바위보 - (int)(Math.random() *3) 가위바위보같은 것..
public class Ex03_random {
	public static void main(String[] args) {
		System.out.println("1부터 45까지의 정수 난수를 발생시키는 방법은? : " + ((int)(Math.random()* 45) +1));
		// +1을 해야하고, int 형변환을 해야하고, 괄호가 많아서 매우 번거로움..
		System.out.println("0부터 2까지의 정수 난수를 발생시키는 방법은? : " + (int)(Math.random()*3));
		// 랜덤형 변수를 새로 만드는 방법!
		Random random = new Random();
		System.out.println("정수형 난수를 발생시키는 방법은? " + random.nextInt()); // -21억에서 +21억 사이.
		System.out.println("double형 난수도 발생가능 : " + random.nextDouble());
		System.out.println("true,false형 난수도 가능 : " + random.nextBoolean()); //true나 false가 랜덤으로..
		System.out.println("특정 범위 내의 난수 발생은? (0~100) : " + random.nextInt(101)); // 101을 입력시, 0부터 100사이.
		System.out.println("0~2 사이의 난수 발생 방법은? : " + random.nextInt(3));
		System.out.println("1~45사이의 정수 난수 발생 방법은? :" + (random.nextInt(45) +1));
	}
	
}
