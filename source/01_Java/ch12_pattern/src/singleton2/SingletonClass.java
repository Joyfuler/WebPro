package singleton2;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass(); // 타입 이름은 클래스 이름과 동일하게.

	private SingletonClass() {
		i = 10;
	} // i를 무조건 10으로 초기화하는 클래스를 생성.

	public static SingletonClass getInstance() {
    // 싱글톤은 INSTANCE 변수 -- getInstance가 관행..
		return INSTANCE;
		// 혹은
		// if (INSTANCE == null){
		// INSTANCE = new SingletonClass(); 
		// return INSTANCE; 로도 가능
		
	} 

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
