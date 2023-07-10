package singleton2;

public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 생성자 실행 중");
		SingletonClass singletonobj = SingletonClass.getInstance();
		// private이므로 new는 불가. SingletonClass에 있는 Instance 메소드를 우회하는 방식으로.
		System.out.println("싱글톤 객체의 i값은? = " + singletonobj.getI()); // i는 10으로 초기화되었으므로 출력은 10
		singletonobj.setI(99); // i값을 99로 수정. (private이므로 set으로 우회)
		System.out.println("싱글톤 객체 i값 수정 후 = " + singletonobj.getI());
		System.out.println("first 생성자 실행 끝------------------------");
		
	}
}
