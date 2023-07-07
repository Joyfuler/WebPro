package com.lec.ex04_actor;

public class ActorTestMain {
	public static void main(String[] args) {
		Actor actor = new Actor("Ž ũ����"); // actor�� �Ű����� x�� �����Ƿ� �ݵ�� name�� �־����..
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
		// fireactor.canCatchCriminal(); -- Ÿ���� IFireFighter�� Ÿ���� ����Ǿ� �ٸ� Ÿ���� �ϴ� ���� �������� ����. 
		// Ÿ���� �ٸ� ������ ������ �� �ִ� ���� �ٷ� ������.
		
		IPoliceMan policeman = actor;
		policeman.canCatchCriminal();
		policeman.canSearch();
		
		
		
		
	}
}
