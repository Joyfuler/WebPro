package com.lec.ex1_string;
//string의 단점을 보완하고자 나온 StringBuffer  >> StringBuilder
public class Ex10_StringBuffer { // 클래스이름주의...
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc"); 
		System.out.println("strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		strBuffer.append("def"); // 뒤에 추가. concat과의 차이는...?
		System.out.println("append 후: " + strBuffer);
		System.out.println("append 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
		strBuffer.delete(3, 5);
		System.out.println("delete 후 :" + strBuffer);
		System.out.println("delete 후 strBuffer의 해쉬코드 : " + strBuffer.hashCode());
	}
}
