package com.lec.ex4_object;

// 클래스에는 데이터(private), 생성자, 일반기능, 메소드(setter&getter), tostring(), 오버라이드할 메소드
// Person p1 = new Person(); // 객체생성. 아무것도 없음 --> null로 잡힘
// Person p2 = new Person(9812121012012L); // 주민번호가 들어간 객체를생성. long juminNo와 같은 주소
public class Person {
	private long juminNo; // 주민번호는 총 13자리. 숫자로 입력한다면 long필요

	public Person() {
	} // 디폴트생성자함수..

	public Person(long juminNo) { // Personmain에서 만들어진 객체는 이 과정을 거침.
		super();
		this.juminNo = juminNo;
	}

	@Override
	public String toString() { // sout할때 왜 오류가 나는지를 확인하기 위해서도 tostring은 오버라이드를 해주자.
		return "주민번호는 [" + juminNo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// p1.equals(p2) : (p1-this, p2-obj).. this.juminNo와 obj.juminNo가 같으면 true, 틀리면
		// false 리턴
		if (obj != null && obj instanceof Person) { // null이 아니고, obj가 Person타입인 경우에만. instanceof는 해당 타입이라는 의미..
			Person other = (Person) obj; // 형변환을 other가 해줌. 밑에다가 (Person)obj).juminNo를 한 것과 동일함.
			boolean juminNoChk = (juminNo == other.juminNo); // 뒤 juminNo는 즉 obj.juminNo (객체의 juminNo)
			return juminNoChk; // 위의 if가 참인 경우는 juminNoChk를 return하고,
		}
		return false; // if가 거짓이라면 false를 return함.
	}

}
