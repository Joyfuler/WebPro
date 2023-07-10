package singleton2;

public class SecondClass {
	public SecondClass() {
		System.out.println("세컨드클래스 생성자 실행 중 ★★★★★★★★");
		SingletonClass obj = SingletonClass.getInstance();
		System.out.println("싱글톤 객체의 i값은? " + obj.getI());
		System.out.println("세컨드클래스 생성자 실행 끝 ★★★★★★★★");
	}
}
