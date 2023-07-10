package singleton1;

public class Single {
	private int i;
	private static Single INSTANCE = new Single(); // instance 변수를 null이 아니라 바로 single 객체로 잡아줌
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}
	// public static Single INSTANCE; // instance라는 single 타입 객체를 생성하고 null로 초기화
							    	// 생성한 적이 없으므로 null이면 없는 것으로 판단함.
	
	//public static Single getInstance() { // getinstance라는 메소드는 static이므로, 
										 // Single.getInstance(); 라는 형태로 호출이 가능 (클래스.메소드 형식)
	// Single형 객체를 생성한 적이 없으면 객체가 만들어짐. 그런데 객체 생성한 것은 어떻게 판단해? if null로
		//if (INSTANCE == null) { // 생성한 적이 없는 것을 판단했으면, 이 안에서는 새롭게 객체를 만들 수 있음.
			//INSTANCE = new Single(); // Single이라는 객체를 생성함.
		
		// 이후 추가로 obj2를 생성했지만, INSTANCE는 이미 null이 아님 (obj1의 주소값이 들어갔으므로)
		// 따라서 single이라는 객체를 추가로 생성하지 않고, 동일한 주소를 가리키게 됨.
		
		//return INSTANCE; // 이후 외부 호출시 INSTANCE를 반환함.
		
		//순서 - 1) 생성자 함수 private화,  2) 이후 싱글형 변수를 static으로 하나 생성. 
		// 3) static형 getInstance()라는 메소드를 만들고 if == null 판단하는 새 객체를 생성. 4) 해당 값을 return
	
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
		
}
