package com.lec.ex2_access;

public class AccessTest {
	private int privateMember;  	// ���� Ŭ���� �������� ����� �� �ִ� �Ű�����
	int defaultMember; 				// �⺻�� (default). ���� ��Ű�������� ��밡��
	protected int protectedMember;  // ���� ��Ű�� or ��ӵ� ��Ű�������� ��밡��.
	public int publicMember;	    // public. ��𿡼��� ����� �� ����.
	
	private void privateMethod() { // private�̹Ƿ� �� Ŭ���� ���� �ٸ� �޼ҵ忡���� ȣ���� ������.
		System.out.println("private �޼ҵ� / privateMember: " + privateMember);				
	}
	void defaultMethod() {
		System.out.println("default �޼ҵ�");		
	}
	protected void protectedMethod() {
		System.out.println("protected �޼ҵ�");
	}
	
	public void publicMethod() {
		System.out.println("public �޼ҵ�");
	}
	
		
	


}
