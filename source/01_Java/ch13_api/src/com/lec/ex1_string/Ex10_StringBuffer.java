package com.lec.ex1_string;
//string�� ������ �����ϰ��� ���� StringBuffer  >> StringBuilder
public class Ex10_StringBuffer { // Ŭ�����̸�����...
	public static void main(String[] args) {
		String str = "abc";
		StringBuffer strBuffer = new StringBuffer("abc"); 
		System.out.println("strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.append("def"); // �ڿ� �߰�. concat���� ���̴�...?
		System.out.println("append ��: " + strBuffer);
		System.out.println("append �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
		strBuffer.delete(3, 5);
		System.out.println("delete �� :" + strBuffer);
		System.out.println("delete �� strBuffer�� �ؽ��ڵ� : " + strBuffer.hashCode());
	}
}
