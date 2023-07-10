package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondobj = new SecondClass(); // 원래는 10이었지만, 앞에 firstclass 생성자를 붙이자 99로 수정되었음.
													// 동일하게 static INSTANCE의 return된 값을 가져오므로, 
													// 수치도 마찬가지가 됨.
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("메인 함수에서의 싱글톤 객체 i값은? " + singobj.getI());
		// 마찬가지로 i값은 99.. 한가지 객체를 계속해서 돌려쓰기가 가능함.
		
		
		
		
	}
}
