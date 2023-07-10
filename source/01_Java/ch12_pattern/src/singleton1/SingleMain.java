package singleton1;

public class SingleMain {
	public static void main(String[] args) {
		Single obj1 = Single.getInstance();
		Single obj2 = Single.getInstance(); // 일반적으로 객체는 new 한 만큼 만들어짐. 싱글톤은...?
		obj1.setI(99); 						// Single에서 만들어진 객체 INSTANCE를 반환하였음.
		System.out.println(obj1.getI());    // obj1에만 99를 set해도 obj2도 마찬가지로 99 가 출력됨.
		System.out.println(obj2.getI());
	}
}
