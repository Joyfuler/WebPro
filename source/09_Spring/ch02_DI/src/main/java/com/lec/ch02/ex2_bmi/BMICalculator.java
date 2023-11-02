package com.lec.ch02.ex2_bmi;

import lombok.Data;

@Data
public class BMICalculator {
	private double lowWeight; // 저체중 bmi 지수 기준점
	private double normal; // 정상체중 bmi 지수 기준점
	private double overWeight; // 과체중 bmi 지수 기준점
	private double obesity; // 비만 bmi 지수 기준점
	
	public void bmiCalculation(double weight, double height) {
		double h = height * 0.01; // 키
		double bmi = weight / (h*h); // 무게 나누기 키 곱하기 2
		System.out.println("BMI 지수는" + bmi);
		if (bmi <= lowWeight) {
			System.out.println("저체중입니다");
		} else if (bmi <= normal) {
			System.out.println("정상체중");
		} else if (bmi <= overWeight) {
			System.out.println("과체중");			
		} else {
			System.out.println("비만입니다");
		}
	}
}
