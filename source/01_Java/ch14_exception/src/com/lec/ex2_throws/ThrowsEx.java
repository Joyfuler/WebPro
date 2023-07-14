package com.lec.ex2_throws;

public class ThrowsEx {

	public ThrowsEx() throws Exception {
		actionC();
	}

	private void actionC() throws Exception { // Runtime���ܰ� �ƴ� ���� ���� ������ ������ �߻�..
		System.out.println("actioncC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");

	}

	private void actionB() throws RuntimeException {
		System.out.println("actionB ���ݺ�");
		actionA();

		System.out.println("actionB �Ĺݺ�");
	}

	private void actionA() throws ArrayIndexOutOfBoundsException { // ������ ���� ���ܸ� �ٸ� ������ �������� ����..
		// ���ܰ� �߻��� ���� �ڽ��� ȣ����� ������ ���ư��Ƿ�, sout �׼�A �Ĺݺδ� ��µ��� ����.
		System.out.println("actionA ���ݺ�");
		int[] arr = { 0, 1 };
		// try {
		System.out.println(arr[2]);
		// } catch (ArrayIndexOutOfBoundsException e) {
		// System.out.println(e.getMessage());

		System.out.println("�׼�A �Ĺݺ�");
	}

}
