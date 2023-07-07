package com.lec.ex04_actor;

public class ActorTestMain {
	public static void main(String[] args) {
		Actor actor = new Actor("탐 크루즈"); // actor에 매개변수 x가 없으므로 반드시 name을 넣어줘야..
		actor.outFire();
		actor.saveMan();
		actor.canCatchCriminal();
		actor.canSearch();
		actor.makePizza();
		actor.makeSpaghetti();
		System.out.println("----------------");
		
		IFireFighter fireactor = actor;
		fireactor.outFire();
		fireactor.saveMan();
		// fireactor.canCatchCriminal(); -- 타입이 IFireFighter로 타입이 변경되어 다른 타입이 하는 일을 수행하지 못함. 
		// 타입을 다른 것으로 변경할 수 있는 것이 바로 다형성.
		
		IPoliceMan policeman = actor;
		policeman.canCatchCriminal();
		policeman.canSearch();
		
		
		
		
	}
}
