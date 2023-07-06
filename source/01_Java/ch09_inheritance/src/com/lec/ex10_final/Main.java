package com.lec.ex10_final;

public class Main {
	public static void main(String[] args) {
		Animal[] animals = {new Animal(), new Dog(), new BlueDog(), new Rabbit()};
		for (Animal anm : animals) {
			System.out.println(anm.getClass().getName()); // 
			anm.running();
			anm.stop();
		}
	}
	
}
