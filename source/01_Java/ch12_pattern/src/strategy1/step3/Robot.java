package strategy1.step3;

public abstract class Robot {
// 로봇 모두가 공통적으로 가진 기능. 모양, 걷고 뛰고...
	public void actionWalk() {
		System.out.println("걸을 수 있습니다.");
	}

	public void actionRun() {
		System.out.println("뛸 수 있습니다.");
	}

	public void shape() { // 슈퍼로봇이면? (무슨무슨) Robot은 팔, 다리, 몸통, 머리가 있습니다.
		String className = getClass().getName(); // 클래스에서 이름을 가져오는 명령어.
		// getclass(). getname()... 해당 클래스의 이름이 classname이라는 변수에 대입됨.
		// 클래스네임은 strategy1.step2.SuperRobot...
		int idx = className.lastIndexOf("."); // 맨 마지막에 나오는 "." 의 위치를 idx로.
		//
		String name = className.substring(idx + 1); // 16번째부터 끄까지 문자열을 추출..
		// 즉 name은 마지막 . 뒤에 있는 글자를 추출한 SuperRobot이 됨.
		System.out.println(name + "의 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
	public abstract void actionFly(); // 반드시 오버라이드하기 위한 추상클래스. abstract를 추가할 것
	public abstract void actionMissile();
	public abstract void actionKnife();
	
	
}
